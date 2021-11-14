/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in MyungJi University 
 */

package Components;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

import Framework.Event;
import Framework.EventId;
import Framework.EventQueue;
import Framework.RMIEventBus;

public class EnrollmentMain {
	private static String studentCheck = "", courseCheck = "";
	public static void main(String args[]) throws FileNotFoundException, IOException, NotBoundException {
		RMIEventBus eventBus = (RMIEventBus) Naming.lookup("//127.0.0.1:1099/EventBus");
		long componentId = eventBus.register();
		System.out.println("** EnrollmentMain(ID:" + componentId + ") is successfully registered. \n");

		EnrollmentComponent enrollmentList = new EnrollmentComponent();
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
				System.out.println(event.getEventId());
				switch (event.getEventId()) {
				case CheckStudentResult:
					printLogEvent("Get", event);
					studentCheck = event.getMessage();
					eventBus.sendEvent(new Event(EventId.ClientOutput, enroll(enrollmentList)));
					break;
				case CheckCourseResult:
					printLogEvent("Get", event);
					courseCheck = event.getMessage();
					eventBus.sendEvent(new Event(EventId.ClientOutput, enroll(enrollmentList)));
					break;
				case ListEnrollments:
					printLogEvent("Get", event);
					eventBus.sendEvent(new Event(EventId.ClientOutput, makeEnrollmentList(enrollmentList)));
					break;
				case QuitTheSystem:
					eventBus.unRegister(componentId);
					done = true;
					break;
				default:
					break;
				}
			}
		}
	}
	private static String enroll(EnrollmentComponent enrollmentList) {
		if(studentCheck.equals("") || courseCheck.equals("")) return "Checking...";
		if(studentCheck.equals("false")) return "Student doesn't exist";
		if(courseCheck.equals("false")) return "Course doesn't exist";
		String[] studentInfo = studentCheck.split(" ");
		String[] courseInfo = courseCheck.split(" ");
		boolean isCompleted = true;
		for(int i = 1; i < courseInfo.length; i++) {
			boolean isCourseCompleted = false;
			for(int j = 1; j < studentInfo.length; j++) {
				if(courseInfo[i].equals(studentInfo[j])) isCourseCompleted = true;
			}
			if(!isCourseCompleted) {
				isCompleted = false;
				break;
			}
		}
		if(isCompleted) {
			enrollmentList.insertEnrollment(studentCheck+" "+courseCheck);
			return "Enroll Success";
		} else {
			return "Student didn't complete the prerequisites";
		}
		
	}
	private static String makeEnrollmentList(EnrollmentComponent enrollmentList) {
		String returnString = "";
		for (int j = 0; j < enrollmentList.vEnrollment.size(); j++) {
			returnString += enrollmentList.getEnrollmentList().get(j).getString() + "\n";
		}
		return returnString;
	}
	private static void printLogEvent(String comment, Event event) {
		System.out.println("\n** " + comment + " the event(ID:" + event.getEventId() + ") message: " + event.getMessage());
	}
}
