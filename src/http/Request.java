package http;

import utils.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Request {
    private String Method;
    private String url;
    private String[] param;
    public Request(InputStream inputStream) {
        //封装HTTP请求包
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            //将请求头先按照空格分割（请求实例：GET /index.php?id=1&session=1234567 HTTP/1.1）
            String[] originReq = bufferedReader.readLine().split(" "); //注意：此处可能会发生IOException
            if (originReq.length == 3) {
                this.Method = originReq[0]; // GET
                String url = originReq[1]; // /index.php?id=1&session=1234567
                if (url.contains("?")) {
                    //分割请求头参数
                    this.url = url.substring(0, url.indexOf("?"));
                    String params = url.substring(url.indexOf("?") + 1);
                    this.param = params.split("&");
                } else {
                    this.url = url;
                }
                if (url.endsWith(".ico"))
                    return; //去死
            }
        } catch (IOException e) {
            //TODO 在此处抛出错误而不是输出，输出交给主方法
            new Logger(3, "Can't read Request.");
        }
    }
    public String getMethod() {
        return this.Method;
    }
    public String getUrl() {
        return this.url;
    }
    public String[] getParam() {
        return this.param;
    }

}
