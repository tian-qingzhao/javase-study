package com.tqz.javase.study.socket.tcp.login2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 双向通信。
 *
 * <p>缺点：客户端传递登录信息是字符串，实际开发中应该传递User对象
 *
 * <p>总结：
 * 1.服务器创建ServerSocket，需要指定监听的端口，会在指定端口监听并处理请求；
 * 2.ServletSocket通过accept() 接收用户请求并返回对应的Socket，否则一种处于监听等待状态，线程也被阻塞
 * 3.客户端创建Socket，需要指定服务器的ip和端口号，向服务器发送请求和接收响应
 * 4.客户端发送数据需要输出流(写)，客户端获取反馈数据需要输入流(读) 	服务端反馈数据需要输出流(写)，服务端获取请求数据需要输入流(读)
 * 5.socket.getInputStream()  socket.getOutputStream() 可以获取网络通信对方的流
 * 6.一旦使用ServerSocket和Socket建立了网络连接后，网络通信和普通IO流操作并没有太大区别
 * 7.网络通信输出流建议使用DataOutputStream和ObjectOutputStream,与平台无关，
 * 输入流相应使用DataIntputStream和ObjectInputStream
 * 8.如果是字符串通信也可以使用BufferedReader和PrintWriter/BufferedWriter，简单方便
 * 9.关闭socket产生的流，会同时关闭掉Socket
 *
 * @author tianqingzhao
 * @since 2023-05-11 20:14
 */
public class LoginServer2 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        // 阻塞接收请求
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String data = dataInputStream.readUTF();
        System.out.println("服务器接收到客户端数据：" + data);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeUTF("你好，客户端");

        dataInputStream.close();
        serverSocket.close();
        socket.close();
    }
}
