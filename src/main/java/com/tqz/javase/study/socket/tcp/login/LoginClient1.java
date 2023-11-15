package com.tqz.javase.study.socket.tcp.login;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 单向通信，客户端向服务端发送数据，服务端接收并打印
 *
 * @author tianqingzhao
 * @since 2023-05-11 20:14
 */
public class LoginClient1 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8080);

        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        String data = "你好，服务端";
        dataOutputStream.writeUTF(data);

        System.out.println("socket流是否关闭：" + socket.isClosed()); // false
        dataOutputStream.close();
        System.out.println("socket流是否关闭：" + socket.isClosed()); // true，说明输出流或输入流关闭之后，socket流也会被关闭
        // outputStream流也会被关闭
    }
}
