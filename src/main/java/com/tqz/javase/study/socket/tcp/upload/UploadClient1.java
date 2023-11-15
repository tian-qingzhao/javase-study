package com.tqz.javase.study.socket.tcp.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 使用tcp进行文件的上传
 *
 * @author tianqingzhao
 * @since 2023-05-13 8:59
 */
public class UploadClient1 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        String path = "D:\\idea_workspace\\javaSE-study\\src\\main\\java\\com\\tqz\\javase\\study\\socket\\tcp" +
                "\\upload\\test.txt";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());

        byte[] buf = new byte[1024];
        int len = 0;
        while (len != -1) {
            bufferedOutputStream.write(buf, 0, len);
            len = bufferedInputStream.read(buf);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close(); // 1.flush 2.关闭流，关闭自己的同时也会关闭socket，因为socket和它有关系

        socket.close();

    }
}
