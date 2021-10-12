
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StudentList {
	protected ArrayList<Data.Student> vStudent;
	public StudentList(String sStudentFileName) throws FileNotFoundException, IOException {
		BufferedReader objStudentFile = new BufferedReader(new FileReader(sStudentFileName));
		this.vStudent = new ArrayList<Data.Student>();
		while (objStudentFile.ready()) {
			String stuInfo = objStudentFile.readLine();
			if (!stuInfo.equals("")) {
				Data.Student.Builder student = Data.Student.newBuilder();
				StringTokenizer stringTokenizer = new StringTokenizer(stuInfo);
				String studentId = stringTokenizer.nextToken();
				String firstName = stringTokenizer.nextToken();
				String secondName = stringTokenizer.nextToken();
				String department = stringTokenizer.nextToken();
				ArrayList<String> completedCoursesList = new ArrayList<String>();
				while (stringTokenizer.hasMoreTokens()) {
					completedCoursesList.add(stringTokenizer.nextToken());
				}
				student.setStudentId(studentId);
				student.setFirstName(firstName);
				student.setSecondName(secondName);
				student.setDepartment(department);
				student.addAllCompletedCourseList(completedCoursesList);
				this.vStudent.add(student.build());
			}
		}
		objStudentFile.close();
	}
	public ArrayList<Data.Student> getAllStudentRecords() {
		return this.vStudent;
	}
	public boolean isRegisteredStudent(String sSID) {
		for (int i = 0; i < this.vStudent.size(); i++) {
			Data.Student objStudent = this.vStudent.get(i);
			if (objStudent.getStudentId().equals(sSID)) {
				return true;
			}
		}
		return false;
	}
	public boolean add(Data.Student student){
		return this.vStudent.add(student);
	}
	public boolean delete(String sNum){
		int delIndex = -1;
		for (int i = 0; i < this.vStudent.size(); i++){
			if (this.vStudent.get(i).getStudentId().equals(sNum)){
				delIndex = i;
			}
		}
		if (delIndex != -1){
			this.vStudent.remove(delIndex);
			return true;
		} else {
			return false;
		}
	}
	public void updateEnrollment(Data.Enrollment enrollment){
		for(Data.Student student: this.vStudent){
			if (student.getStudentId().equals(enrollment.getStudentId())){
				System.out.println(student.getCompletedCourseListList().size());
			}
		}
	}
}
