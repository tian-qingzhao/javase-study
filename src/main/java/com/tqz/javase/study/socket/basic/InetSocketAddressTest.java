package com.tqz.javase.study.socket.basic;

import java.net.InetSocketAddress;

/**
 * @author tianqingzhao
 * @since 2023-05-10 21:32
 */
public class InetSocketAddressTest {

    public static void main(String[] args) {
        InetSocketAddress socketAddress = new InetSocketAddress("localhost", 8080);
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress.getPort());
        System.out.println(socketAddress.getAddress());
        System.out.println(socketAddress.getHostString());
    }
}
