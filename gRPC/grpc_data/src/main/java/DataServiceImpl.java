import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class DataServiceImpl extends DataServiceGrpc.DataServiceImplBase {
    private StudentList sList;
    private CourseList cList;
    private EnrollmentList eList;
    public DataServiceImpl(){
        try {
            sList = new StudentList("/Users/mint/Desktop/IntelliJ-workspace/grpc_data/src/main/java/Students.txt");
            cList = new CourseList("/Users/mint/Desktop/IntelliJ-workspace/grpc_data/src/main/java/Courses.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.eList = new EnrollmentList();
    }
    @Override
    public void getStudents(Data.StudentRequest request, StreamObserver<Data.StudentResponse> responseObserver)  {
        Data.StudentResponse.Builder a = Data.StudentResponse.newBuilder();
        a.addAllStudentList(this.sList.getAllStudentRecords());
        Data.StudentResponse response = a.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    @Override
    public void addStudent(Data.Student request, StreamObserver<Data.IsSuccess> responseObserver) {
        Data.IsSuccess.Builder response = Data.IsSuccess.newBuilder();
        response.setIsSuccess(this.sList.getAllStudentRecords().add(request));
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
    @Override
    public void deleteStudent(Data.deleteNum request, StreamObserver<Data.IsSuccess> responseObserver) {
        Data.IsSuccess.Builder response = Data.IsSuccess.newBuilder();
        response.setIsSuccess(this.sList.delete(request.getDelNum()));
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
    @Override
    public void getCourses(Data.CourseRequest request, StreamObserver<Data.CourseResponse> responseObserver) {
        Data.CourseResponse.Builder a = Data.CourseResponse.newBuilder();
        a.addAllCourseList(this.cList.getAllCourseRecords());
        Data.CourseResponse response = a.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    @Override
    public void addCourse(Data.Course request, StreamObserver<Data.IsSuccess> responseObserver) {
        Data.IsSuccess.Builder response = Data.IsSuccess.newBuilder();
        response.setIsSuccess(this.cList.getAllCourseRecords().add(request));
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
    @Override
    public void deleteCourse(Data.deleteNum request, StreamObserver<Data.IsSuccess> responseObserver) {
        Data.IsSuccess.Builder response = Data.IsSuccess.newBuilder();
        response.setIsSuccess(this.cList.delete(request.getDelNum()));
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getEnrollment(Data.EnrollmentRequest request, StreamObserver<Data.EnrollmentResponse> responseObserver) {
        Data.EnrollmentResponse.Builder a = Data.EnrollmentResponse.newBuilder();
        a.addAllEnrollmentList(this.eList.getEnrollmentList());
        Data.EnrollmentResponse response = a.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    @Override
    public void enroll(Data.Enrollment request, StreamObserver<Data.IsEnroll> responseObserver) {
        this.eList.addEnrollment(request);
        this.sList.updateEnrollment(request);
        Data.IsEnroll.Builder response = Data.IsEnroll.newBuilder();
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
