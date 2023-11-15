package com.tqz.javase.study.socket.tcp.login2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 双向通信
 *
 * @author tianqingzhao
 * @since 2023-05-11 20:14
 */
public class LoginClient2 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8080);

        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        String data = "你好，服务端";
        dataOutputStream.writeUTF(data);

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        System.out.println("客户端接收到服务端数据：" + dataInputStream.readUTF());

        System.out.println("socket流是否关闭：" + socket.isClosed()); // false
        dataOutputStream.close();
        System.out.println("socket流是否关闭：" + socket.isClosed()); // true，说明输出流或输入流关闭之后，socket流也会被关闭
    }
}
