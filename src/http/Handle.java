package http;

import utils.Logger;
import utils.ReadFile;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Handle extends Thread {
    private static final String HTTP_SUCCESS = "200";
    private static final String HTTP_NOT_FOUND = "404";

    private Socket socket;
    private String address;
    private Integer port;
    private String status;
    private String url;

    public Handle(Socket socket) {
        this.socket = socket;
        InetAddress inetAddress = socket.getInetAddress();
        this.address = inetAddress.getHostAddress();
        this.port = socket.getLocalPort();
    }

    @Override
    public void run() {
        try {
            Request req = new Request(socket.getInputStream());
            Response rsp = new Response(socket.getOutputStream());
            String url = req.getUrl();
            try {
                StringBuilder stringBuilder = new ReadFile(url).readFile();
                OutputStream outputStream = rsp.getOutputStream();
                outputStream.write((Response.HTTP_HEADER + stringBuilder.toString()).getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();
            } catch (NullPointerException n) {
                System.out.print("");
            }
        } catch (IOException e) {
            new Logger(3, "InputStream or OutputStream throws an IOException");
        }
    }
}
