import java.util.ArrayList;

public class EnrollmentList {
    private ArrayList<Data.Enrollment> eList;
    public EnrollmentList(){
        this.eList = new ArrayList<Data.Enrollment>();
    }
    public void addEnrollment(Data.Enrollment enrollment){
        this.eList.add(enrollment);
    }
    public ArrayList<Data.Enrollment> getEnrollmentList(){
        return this.eList;
    }
}
