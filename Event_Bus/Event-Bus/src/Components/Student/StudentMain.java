/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in MyungJi University 
 */

package Components.Student;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

import Framework.Event;
import Framework.EventId;
import Framework.EventQueue;
import Framework.RMIEventBus;

public class StudentMain {
	public static void main(String args[]) throws FileNotFoundException, IOException, NotBoundException {
		RMIEventBus eventBus = (RMIEventBus) Naming.lookup("//127.0.0.1:1099/EventBus");
		long componentId = eventBus.register();
		System.out.println("** StudentMain(ID:" + componentId + ") is successfully registered. \n");

		StudentComponent studentsList = new StudentComponent("Students.txt");
		Event event = null;
		boolean done = false;
		while (!done) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			EventQueue eventQueue = eventBus.getEventQueue(componentId);
			for (int i = 0; i < eventQueue.getSize(); i++) {
				event = eventQueue.getEvent();
				switch (event.getEventId()) {
				case ListStudents:
					printLogEvent("Get", event);
					eventBus.sendEvent(new Event(EventId.ClientOutput, makeStudentList(studentsList)));
					break;
				case RegisterStudents:
					printLogEvent("Get", event);
					eventBus.sendEvent(new Event(EventId.ClientOutput, registerStudent(studentsList, event.getMessage())));
					break;
				case DeleteStudent:
					printLogEvent("Get", event);
					eventBus.sendEvent(new Event(EventId.ClientOutput, deleteStudent(studentsList, event.getMessage())));
					break;
				case CheckStudentId:
					printLogEvent("Get", event);
					if(checkStudentId(studentsList, event.getMessage()).equals("false")) eventBus.sendEvent(new Event(EventId.ClientOutput, "There is no Student"));
					else eventBus.sendEvent(new Event(EventId.CheckCourseId, checkStudentId(studentsList, event.getMessage())));
					break;
				case QuitTheSystem:
					printLogEvent("Get", event);
					eventBus.unRegister(componentId);
					done = true;
					break;
				default:
					break;
				}
			}
		}
	}
	private static String checkStudentId(StudentComponent studentsList, String message) {
		String studentId = message.split(" ")[0];
		String courseId = message.split(" ")[1];
		if (studentsList.isRegisteredStudent(studentId)) {
			String rValue = studentId+"\r\n";
			if(studentsList.getStudentById(studentId).getCompletedCourses().size() == 0) rValue += "nothing";
			else {
				for(String completeCourse: studentsList.getStudentById(studentId).getCompletedCourses()) {
					rValue += completeCourse+" ";
				}
			}
			return rValue+"\r\n"+courseId;
		} else return "false";
	}
	private static String registerStudent(StudentComponent studentsList, String message) {
		Student  student = new Student(message);
		if (!studentsList.isRegisteredStudent(student.studentId)) {
			studentsList.vStudent.add(student);
			return "This student is successfully added.";
		} else
			return "This student is already registered.";
	}
	private static String makeStudentList(StudentComponent studentsList) {
		String returnString = "";
		for (int j = 0; j < studentsList.vStudent.size(); j++) {
			returnString += studentsList.getStudentList().get(j).getString() + "\n";
		}
		return returnString;
	}
	private static String deleteStudent(StudentComponent studentsList, String studentId) {
		if (studentsList.isRegisteredStudent(studentId)) {
			studentsList.deleteStudent(studentId);
			return "This student is successfully deleted.";
		} else {
			return "This student is not exist.";
		}
	}
	private static void printLogEvent(String comment, Event event) {
		System.out.println(
				"\n** " + comment + " the event(ID:" + event.getEventId() + ") message: " + event.getMessage());
	}
}
