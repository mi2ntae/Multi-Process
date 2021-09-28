import io.grpc.stub.StreamObserver;

public class ServerServiceImpl extends DataServiceGrpc.DataServiceImplBase {
    private Server_Data client_data;

    public ServerServiceImpl(){
        this.client_data = new Server_Data();
    }
    @Override
    public void getStudents(Data.StudentRequest request, StreamObserver<Data.StudentResponse> responseObserver)  {
        responseObserver.onNext(this.client_data.getStudents());
        responseObserver.onCompleted();
    }

    @Override
    public void getCourses(Data.CourseRequest request, StreamObserver<Data.CourseResponse> responseObserver) {
        responseObserver.onNext(this.client_data.getCourses());
        responseObserver.onCompleted();
    }
}
