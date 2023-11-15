package com.tqz.javase.study.socket.udp.ask2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP双向通信
 *
 * @author tianqingzhao
 * @since 2023-05-12 19:42
 */
public class AskClient2 {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8889);

        String data = "你好，服务端";
        byte[] bytes = data.getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 8089);
        socket.send(packet);

        byte[] buf = new byte[1024];
        DatagramPacket packet2 = new DatagramPacket(buf, buf.length);
        socket.receive(packet2);
        System.out.println("客户端接收服务端的数据：" + new String(packet2.getData(), 0, packet2.getLength()));

        socket.close();

    }
}
