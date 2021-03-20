package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

// TODO: 20.03.2021 12.3.3
public class Client implements Runnable {

    Socket socket;
    Scanner in;
    PrintStream out;
    ChatServer chatServer;

    Client(Socket socket, ChatServer chatServer) {
        this.socket = socket;
        this.chatServer = chatServer;
        new Thread(this).start();
    }

    void receivedAll(String msg) {
        out.println(msg);
    }

    @Override
    public void run() {

        try {
            // получаем потоки ввода и вывода
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            // создаем удобные средства ввода и вывода
            in = new Scanner(is);
            out = new PrintStream(os);

            // читаем из сети и пишем в сеть
            out.println("Welcome to mountains!");
            String input = in.nextLine();
            while (!input.equals("exit")) {
                chatServer.sendAll(input);
                input = in.nextLine();
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
