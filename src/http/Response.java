package http;

import java.io.OutputStream;

public class Response {
    private OutputStream outputStream;
    public static final String HTTP_HEADER =
            "HTTP/1.1 200\r\n"
            + "Context-type: text/html\r\n"
            + "\r\n";
    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public OutputStream getOutputStream() {
        return this.outputStream;
    }
}
