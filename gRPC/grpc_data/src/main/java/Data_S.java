import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Data_S {
    private static final int PORT = 9090;
    private Server server;

    public void start() throws IOException {
        server = ServerBuilder.forPort(PORT)
                .addService(new DataServiceImpl())
                .build();
        try {
            server.start().awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
            throws InterruptedException, IOException {
        Data_S server = new Data_S();
        server.start();
    }
}
