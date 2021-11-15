/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in MyungJi University 
 */

package Components.Enrollment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

import Framework.Event;
import Framework.EventId;
import Framework.EventQueue;
import Framework.RMIEventBus;

public class EnrollmentMain {
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
				switch (event.getEventId()) {
				case CheckIdResult:
					printLogEvent("Get", event);
					eventBus.sendEvent(new Event(EventId.ClientOutput, enroll(enrollmentList, event.getMessage())));
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
	private static String enroll(EnrollmentComponent enrollmentList, String message) {
		String[] mes = message.split("\r\n");
		String studentId = mes[0].strip();
		String courseId = mes[2].strip();
		String[] studentInfo = mes[1].split(" ");
		String[] courseInfo = mes[3].split(" ");
		if(courseInfo.equals("false")) {
			enrollmentList.insertEnrollment(studentId+" "+courseId);
			return "Enroll Success";
		}
		boolean isCompleted = true;
		for(int i = 1; i < courseInfo.length; i++) {
			boolean isCourseCompleted = false;
			for(int j = 1; j < studentInfo.length; j++) {
				if(courseInfo[i].strip().equals(studentInfo[j].strip())) isCourseCompleted = true;
			}
			if(!isCourseCompleted) {
				isCompleted = false;
				break;
			}
		}
		if(isCompleted) {
			enrollmentList.insertEnrollment(studentId+" "+courseId);
			return "Enroll Success";
		} else {
			return "Student didn't complete the prerequisites";
		}
		
	}
	private static String makeEnrollmentList(EnrollmentComponent enrollmentList) {
		String returnString = "";
		if(enrollmentList.vEnrollment.size() == 0) return "No element in Enrollment List";
		for (int j = 0; j < enrollmentList.vEnrollment.size(); j++) {
			returnString += enrollmentList.getEnrollmentList().get(j).getString() + "\n";
		}
		return returnString;
	}
	private static void printLogEvent(String comment, Event event) {
		System.out.println("\n** " + comment + " the event(ID:" + event.getEventId() + ") message: " + event.getMessage());
	}
}
