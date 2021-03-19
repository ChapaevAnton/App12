package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) throws IOException {
        // создаем серверный сокет на порту 1234
        ServerSocket server = new ServerSocket(1234);
        while (true) {
            System.out.println("Waiting...");

            // ждем клиента
            Socket socket = server.accept();
            System.out.println("Client connected!");

            Thread threadService = new Thread(new Client(socket));
            threadService.start();
        }
    }
}
