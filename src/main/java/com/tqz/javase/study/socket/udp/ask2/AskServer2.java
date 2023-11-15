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
public class AskServer2 {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8089);

        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);

        System.out.println("服务端接收到客户端数据：" + new String(packet.getData(), 0, packet.getLength()));
        System.out.println(packet.getAddress()); // ip
        System.out.println(packet.getSocketAddress()); // ip:port
        System.out.println(packet.getLength());
        System.out.println(packet.getPort());

        String data = "你好，客户端";
        byte[] bytes = data.getBytes();
        DatagramPacket packet2 = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 8889);
        socket.send(packet2);

        socket.close();
    }
}
