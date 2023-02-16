package utils;

import java.sql.Array;

public class ReadFile {
    private String fileName;
    private String encode = "UTF-8";
    public ReadFile(String fileName, String encode) {
        this.fileName = fileName;
        this.encode = encode;
    }
    public ReadFile(String fileName) {
        this.fileName = fileName;
    }
    public ReadFile() {

    }

    public StringBuilder readFile() {
        if (!this.fileName.equalsIgnoreCase("/")) {
            //TODO 读取文件
            return null; //如果返回null，状态码返回HTTP_NOT_FOUND
        } else {
            //return new String[]{"<h1 align=\"center\">Fish HTTP Server v1.0 </h1>\r\n"};
            return new StringBuilder("<h1 align=\"center\">Fish HTTP Server v1.0 </h1>\r\n");
        }
    }
}
