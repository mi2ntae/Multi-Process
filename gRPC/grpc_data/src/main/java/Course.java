
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Course implements Serializable{

	private static final long serialVersionUID = 1L;

	protected String courseId;
    protected String pfName;
    protected String name;
    protected ArrayList<String> prerequisites;

    public Course(String inputString) {
        StringTokenizer stringTokenizer = new StringTokenizer(inputString);
    	this.courseId = stringTokenizer.nextToken();
    	this.pfName = stringTokenizer.nextToken();
        this.name = stringTokenizer.nextToken();
    	//this.name = this.name + " " + stringTokenizer.nextToken();
    	this.prerequisites = new ArrayList<String>();
    	while (stringTokenizer.hasMoreTokens()) {
    		this.prerequisites.add(stringTokenizer.nextToken());
    	}
    }

    public String getCourseId() {
        return courseId;
    }

    public String getPfName() {
        return pfName;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getPrerequisites() {
        return prerequisites;
    }

    public boolean match(String courseId) {
        return this.courseId.equals(courseId);
    }

    public String toString() {
        String stringReturn = this.courseId + " " + this.pfName + " " + this.name;
        for (int i = 0; i < this.prerequisites.size(); i++) {
            stringReturn = stringReturn + " " + this.prerequisites.get(i).toString();
        }
        return stringReturn;
    }

}
