package com.tqz.javase.study.socket.udp.ask;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP单向通信
 *
 * @author tianqingzhao
 * @since 2023-05-12 19:42
 */
public class AskClient1 {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8889);

        String data = "你好，服务端";
        byte[] bytes = data.getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 8089);

        socket.send(packet);

        socket.close();

    }
}
