package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

// TODO: 20.03.2021 12.3.3
public class ChatServer {

    ArrayList<Client> clientList = new ArrayList<>();
    ServerSocket serverSocket;

    ChatServer() throws IOException {
        // создаем серверный сокет на порту 1234
        serverSocket = new ServerSocket(1234);
    }

    void sendAll(String msg) {
        for (Client client : clientList) {
            client.receivedAll(msg);
        }

    }

    void run() {
        while (true) {
            System.out.println("Waiting...");
            try {
                // ждем клиента
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");
                clientList.add(new Client(socket, this));

            } catch (IOException err) {
                err.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {

        new ChatServer().run();

    }
}
