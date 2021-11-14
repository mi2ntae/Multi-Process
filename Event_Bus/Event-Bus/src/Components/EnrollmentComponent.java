/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in MyungJi University 
 */

package Components;

import java.util.ArrayList;

public class EnrollmentComponent {
	protected ArrayList<Enrollment> vEnrollment = new ArrayList<Enrollment>();

	public ArrayList<Enrollment> getEnrollmentList() {
		return vEnrollment;
	}
	public boolean insertEnrollment(String s) {
		Enrollment enrollment = new Enrollment(s);
		enrollment.setEnrollmentId(Integer.toString(this.vEnrollment.size()));
		return this.vEnrollment.add(enrollment);
	}
	public boolean isRegisteredEnrollment(String enrollmentId) {
		for (int i = 0; i < this.vEnrollment.size(); i++) {
			if (((Enrollment) this.vEnrollment.get(i)).match(enrollmentId)) return true;
		}
		return false;
	}
	public boolean deleteEnrollment(String enrollmentId) {
		int deleteIndex = -1;
		for(int i = 0; i < this.vEnrollment.size()-1; i++) {
			if(this.vEnrollment.get(i).getEnrollmentId().equals(enrollmentId)) {
				deleteIndex = i;
			}
		}
		this.vEnrollment.remove(deleteIndex);
		return true;
	}
}
