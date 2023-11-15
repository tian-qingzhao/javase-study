package com.tqz.javase.study.socket.udp.ask3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * UDP多次双向通信
 *
 * @author tianqingzhao
 * @since 2023-05-12 19:42
 */
public class AskServer3 {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8089);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);

            String msg = new String(packet.getData(), 0, packet.getLength());
            if ("bye".equals(msg)) {
                break;
            }
            System.out.println("服务端接收到客户端数据：" + msg);

            String data = scanner.nextLine();
            byte[] bytes = data.getBytes();
            DatagramPacket packet2 = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 8889);
            socket.send(packet2);
        }

        socket.close();
    }
}
