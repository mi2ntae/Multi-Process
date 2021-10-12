import io.grpc.ServerBuilder;

import java.io.IOException;

public class ServerServiceStart {
    private static final int PORT = 9091;
    private io.grpc.Server server;
    public void start() throws IOException {
        server = ServerBuilder.forPort(PORT)
                .addService(new ServerServiceImpl())
                .build();
        try {
            System.out.println("Server is ready");
            server.start().awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException, IOException {
        ServerServiceStart server = new ServerServiceStart();
        server.start();
    }
}
