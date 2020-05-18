package net.http;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) {
        // URL可以分为几个部分: ①协议类型 :// ②主机 : ③端口 /④资源路径
        // 代表了web上的一个资源
        try {
            URL url = new URL("https://www.baidu.com");
            // 1. 创建连接对象，这个时候还没有实际连接动作
            URLConnection connection = url.openConnection();

            // 2. 设置连接参数和属性
            connection.setAllowUserInteraction(true);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setIfModifiedSince(System.currentTimeMillis());
            connection.setUseCaches(true);
            connection.setConnectTimeout(1000);
            connection.setReadTimeout(5000);
            // 设置HTTP请求头
            connection.setRequestProperty("key", "value");

            // 3. 发起连接
            connection.connect();

            // 4. 等待响应，并从响应中读取数据，如果调用时没有连接，则会隐式进行 connection.connect()
            connection.getContent();
            connection.getHeaderField("key");
            //
            connection.getInputStream();
            connection.getOutputStream();



        } catch (IOException e) {
            // MalformedURLException: URL格式不正确
            e.printStackTrace();
        }

    }
}
