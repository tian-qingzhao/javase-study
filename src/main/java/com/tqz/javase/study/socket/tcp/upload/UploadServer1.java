package com.tqz.javase.study.socket.tcp.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 使用tcp上传文件
 *
 * @author tianqingzhao
 * @since 2023-05-13 9:02
 */
public class UploadServer1 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        Socket socket = serverSocket.accept();

        String path = "D:\\idea_workspace\\javaSE-study\\src\\main\\java\\com\\tqz\\javase\\study\\socket\\tcp" +
                "\\upload\\test2.txt";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path));
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());

        byte[] buf = new byte[1024];
        int len = 0;
        while (len != -1) {
            bufferedOutputStream.write(buf, 0, len);

            len = bufferedInputStream.read(buf);
        }
        bufferedOutputStream.close();
        bufferedInputStream.close(); // 1.flush 2.关闭流，关闭自己的同时也会关闭socket，因为socket和它有关系

        socket.close();
    }
}
