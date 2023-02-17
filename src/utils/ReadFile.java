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
            return stringBuilder;
        } catch (FileNotFoundException e) {
            return new StringBuilder("<h1 align=\"center\">404 Not Found</h1>\r\n);
        return null;
    } else {
        try {
            return new ReadFile("index.html").readFile();
        } catch (Exception e) {
            return new StringBuilder("<h1 align=\"center\">404 Not Found</h1>\r\n);
        }
    }
}
