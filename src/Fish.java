import http.Handle;
import utils.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Fish {
    public static final Integer PORT = 1080; //HTTP监听端口
    public static void main(String[] args) {
        new Logger(1, "Starting Fish HTTP Server at " + PORT.toString());
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                //TODO 开启新的线程处理连接
                Thread t = new Handle(socket);
                t.start();
            }
        } catch (IOException e) {
            new Logger(3, "Can't bind port " + PORT + ": address is already in use.");
        }
    }
}