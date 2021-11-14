package Components;

import java.util.StringTokenizer;

public class Enrollment {
	protected String enrollmentId;
	protected String studentId;
	protected String courseId;
	
	public Enrollment(String inputString) {
		StringTokenizer stringTokenizer = new StringTokenizer(inputString);
		this.studentId = stringTokenizer.nextToken();
		this.courseId = stringTokenizer.nextToken();
	}
	public boolean match(String enrollmentId) {
		return this.enrollmentId.equals(enrollmentId);
	}
	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	public String getEnrollmentId() {
		return this.enrollmentId;
	}
	public String getStudentId() {
		return this.studentId;
	}
	public String getCourseId() {
		return this.courseId;
	}
	public String getString() {
		String stringReturn = this.enrollmentId + " " + this.studentId + " " + this.courseId;
		return stringReturn;
	}
}
