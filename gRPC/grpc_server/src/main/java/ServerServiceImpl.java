import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;

public class ServerServiceImpl extends DataServiceGrpc.DataServiceImplBase {
    private final int port = 9090;
    private ManagedChannel channel;
    private DataServiceGrpc.DataServiceBlockingStub stub;
    public ServerServiceImpl(){
        this.channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();
        System.out.println("Request Students Data to "+port);
        this.stub = DataServiceGrpc.newBlockingStub(channel);
    }
    @Override
    public void getStudents(Data.StudentRequest request, StreamObserver<Data.StudentResponse> responseObserver)  {
        Data.StudentResponse response = stub.getStudents(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    @Override
    public void addStudent(Data.Student request, StreamObserver<Data.IsSuccess> responseObserver) {
        Data.IsSuccess response = this.stub.addStudent(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteStudent(Data.deleteNum request, StreamObserver<Data.IsSuccess> responseObserver) {
        boolean isExist = false;
        Data.StudentResponse checkResponse = this.stub.getStudents(Data.StudentRequest.newBuilder().build());
        for(int i = 0; i < checkResponse.getStudentListCount(); i++){
            if (checkResponse.getStudentList(i).getStudentId().equals(request.getDelNum())){
                isExist = true;
            }
        }
        Data.IsSuccess response = null;
        if (isExist){
            response = this.stub.deleteStudent(request);
        } else {
            Data.IsSuccess.Builder responseBuilder = Data.IsSuccess.newBuilder();
            responseBuilder.setIsSuccess(false);
            response = responseBuilder.build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    @Override
    public void getCourses(Data.CourseRequest request, StreamObserver<Data.CourseResponse> responseObserver) {
        Data.CourseResponse response = stub.getCourses(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    @Override
    public void addCourse(Data.Course request, StreamObserver<Data.IsSuccess> responseObserver) {
        Data.IsSuccess response = this.stub.addCourse(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    @Override
    public void deleteCourse(Data.deleteNum request, StreamObserver<Data.IsSuccess> responseObserver) {
        boolean isExist = false;
        Data.CourseResponse checkResponse = this.stub.getCourses(Data.CourseRequest.newBuilder().build());
        for(int i = 0; i < checkResponse.getCourseListCount(); i++){
            if (checkResponse.getCourseList(i).getCourseId().equals(request.getDelNum())){
                isExist = true;
            }
        }
        Data.IsSuccess response = null;
        if (isExist){
            response = this.stub.deleteCourse(request);
        } else {
            Data.IsSuccess.Builder responseBuilder = Data.IsSuccess.newBuilder();
            responseBuilder.setIsSuccess(false);
            response = responseBuilder.build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    @Override
    public void getEnrollment(Data.EnrollmentRequest request, StreamObserver<Data.EnrollmentResponse> responseObserver) {
        Data.EnrollmentResponse response = stub.getEnrollment(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    @Override
    public void enroll(Data.Enrollment request, StreamObserver<Data.IsEnroll> responseObserver) {
        boolean isStudentExist = false;
        Data.Student student = null;
        Data.StudentResponse checkStudentResponse = this.stub.getStudents(Data.StudentRequest.newBuilder().build());
        for(int i = 0; i < checkStudentResponse.getStudentListCount(); i++){
            if (checkStudentResponse.getStudentList(i).getStudentId().equals(request.getStudentId())){
                isStudentExist = true;
                student = checkStudentResponse.getStudentList(i);
            }
        }
        boolean isCourseExist = false;
        Data.Course course = null;
        Data.CourseResponse checkCourseResponse = this.stub.getCourses(Data.CourseRequest.newBuilder().build());
        for(int i = 0; i < checkCourseResponse.getCourseListCount(); i++){
            if (checkCourseResponse.getCourseList(i).getCourseId().equals(request.getCourseId())){
                isCourseExist = true;
                course = checkCourseResponse.getCourseList(i);
            }
        }
        Data.IsEnroll.Builder response = Data.IsEnroll.newBuilder();
        if (isStudentExist){
            response.setIsStudentExist(true);
            if (isCourseExist){
                response.setIsCourseExist(true);
                boolean isEnrolled = false;
                if (student.getCompletedCourseListList().size() == 0){
                    isEnrolled = true;
                } else {
                    for (String complete: student.getCompletedCourseListList()){
                        for (String need: course.getPrerequisitesList()){
                            if (complete.equals(need)){
                                isEnrolled = true;
                            }
                        }
                    }
                }
                response.setIsPrerequisitesDone(isEnrolled);
                if (isEnrolled){
                    this.stub.enroll(request);
                }
            }
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
