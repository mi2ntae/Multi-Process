
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CourseList {
	protected ArrayList<Data.Course> vCourse;
	public CourseList(String sCourseFileName) throws FileNotFoundException, IOException {
		BufferedReader objCourseFile = new BufferedReader(new FileReader(sCourseFileName));
		this.vCourse = new ArrayList<Data.Course>();
		while (objCourseFile.ready()) {
			String couInfo = objCourseFile.readLine();
			if (!couInfo.equals("")) {
				Data.Course.Builder course = Data.Course.newBuilder();
				StringTokenizer stringTokenizer = new StringTokenizer(couInfo);
				String courseId = stringTokenizer.nextToken();
				String pfName = stringTokenizer.nextToken();
				String name = stringTokenizer.nextToken();
				ArrayList<String> prerequisites = new ArrayList<String>();
				while (stringTokenizer.hasMoreTokens()) {
					prerequisites.add(stringTokenizer.nextToken());
				}
				course.setCourseId(courseId);
				course.setPfName(pfName);
				course.setName(name);
				course.addAllPrerequisites(prerequisites);
				this.vCourse.add(course.build());
			}
		}
		objCourseFile.close();
	}
	public ArrayList<Data.Course> getAllCourseRecords() {
		return this.vCourse;
	}
	public boolean isRegisteredCourse(String cSID) {
		for (int i = 0; i < this.vCourse.size(); i++) {
			Data.Course objCourse = this.vCourse.get(i);
			if (objCourse.getCourseId().equals(cSID)) {
				return true;
			}
		}
		return false;
	}
	public boolean delete(String delNum) {
		int delIndex = -1;
		for (int i = 0; i < this.vCourse.size(); i++){
			if (this.vCourse.get(i).getCourseId().equals(delNum)){
				delIndex = i;
			}
		}
		if (delIndex != -1){
			this.vCourse.remove(delIndex);
			return true;
		} else {
			return false;
		}
	}
}
