import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.ArrayList;

public class Server_Data {
    private final int port = 9090;

    public Data.StudentResponse getStudents() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port)
                .usePlaintext().build();
        System.out.println("Request Students Data to "+port);
        DataServiceGrpc.DataServiceBlockingStub stub = DataServiceGrpc.newBlockingStub(channel);
        Data.StudentResponse response = stub.getStudents(Data.StudentRequest.newBuilder().build());
        channel.shutdown();

        return response;
    }

    public Data.CourseResponse getCourses() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port)
                .usePlaintext().build();
        System.out.println("Request Courses Data to "+port);
        DataServiceGrpc.DataServiceBlockingStub stub = DataServiceGrpc.newBlockingStub(channel);
        Data.CourseResponse response = stub.getCourses(Data.CourseRequest.newBuilder().build());
        channel.shutdown();
        return response;
    }
}

