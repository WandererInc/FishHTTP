package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
            try {
                StringBuilder stringBuilder = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new FileReader(this.fileName));
                String str;
                while ((str = bufferedReader.readLine()) != null) {
                    stringBuilder.append(str);
                    stringBuilder.append("\r\n");
                }
            } catch (FileNotFoundException e) {
                //TODO 抛出404错误
                new Logger(4, "404 Not Found. No such file ", fileName);
                return new StringBuilder("<h1 align=\"center\">404 Not Found</h1>\r\n<h3 align=\"center\">Fish HTTP Server v1.0 </h3>");
            } catch (IOException e) {
                new Logger(4,"Can't read file ", fileName);
            }
            return null; //如果返回null，状态码返回HTTP_NOT_FOUND
        } else {
            //return new String[]{"<h1 align=\"center\">Fish HTTP Server v1.0 </h1>\r\n"};
            return new StringBuilder("<h1 align=\"center\">Fish HTTP Server v1.0 </h1>\r\n");
        }
    }
}
