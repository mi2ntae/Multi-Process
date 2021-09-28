
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected String studentId;
    protected String firstName;
    protected String secondName;
    protected String department;
    protected ArrayList<String> completedCoursesList;
 
    public Student(String inputString) {
        StringTokenizer stringTokenizer = new StringTokenizer(inputString);
    	this.studentId = stringTokenizer.nextToken();
    	this.firstName = stringTokenizer.nextToken();
        this.secondName = stringTokenizer.nextToken();
    	//this.name = this.name + " " + stringTokenizer.nextToken();
    	this.department = stringTokenizer.nextToken();
    	this.completedCoursesList = new ArrayList<String>();
    	while (stringTokenizer.hasMoreTokens()) {
    		this.completedCoursesList.add(stringTokenizer.nextToken());
    	}
    }

    public boolean match(String studentId) {
        return this.studentId.equals(studentId);
    }

    public String getStudentId() {
        return studentId;
    }

    public String getDepartment() { return department; }

    public String getFirstName() {
        return this.firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public ArrayList<String> getCompletedCourses() {
        return this.completedCoursesList;
    }

    public String toString() {
        String stringReturn = this.studentId + " " + this.firstName + " " + this.secondName+ " " + this.department;
        for (int i = 0; i < this.completedCoursesList.size(); i++) {
            stringReturn = stringReturn + " " + this.completedCoursesList.get(i).toString();
        }
        return stringReturn;
    }

}
