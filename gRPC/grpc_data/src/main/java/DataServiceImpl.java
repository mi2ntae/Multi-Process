import io.grpc.stub.StreamObserver;


import java.io.IOException;
import java.util.ArrayList;

public class DataServiceImpl extends DataServiceGrpc.DataServiceImplBase {
    @Override
    public void getStudents(Data.StudentRequest request, StreamObserver<Data.StudentResponse> responseObserver)  {
        StudentList sList = null;
        try {
             sList = new StudentList("/Users/mint/Desktop/IntelliJ-workspace/grpc_data/src/main/java/Students.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Data.StudentResponse.Builder a = Data.StudentResponse.newBuilder();
        for (Student s: sList.getAllStudentRecords()){
            Data.Student.Builder student = Data.Student.newBuilder();
            student.setStudentId(s.getStudentId());
            student.setFirstName(s.getFirstName());
            student.setSecondName(s.getSecondName());
            student.setDepartment(s.getDepartment());
            student.addAllCompletedCourseList(s.getCompletedCourses());
            a.addStudentList(student);
        }
        Data.StudentResponse response = a.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getCourses(Data.CourseRequest request, StreamObserver<Data.CourseResponse> responseObserver) {
        CourseList cList = null;
        try {
            cList = new CourseList("/Users/mint/Desktop/IntelliJ-workspace/grpc_data/src/main/java/Courses.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Data.CourseResponse.Builder a = Data.CourseResponse.newBuilder();
        for (Course c: cList.getAllCourseRecords()){
            Data.Course.Builder course = Data.Course.newBuilder();
            course.setCourseId(c.getCourseId());
            course.setPfName(c.getPfName());
            course.setName(c.getName());
            course.addAllPrerequisites(c.getPrerequisites());
            a.addCourseList(course);
        }
        Data.CourseResponse response = a.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
