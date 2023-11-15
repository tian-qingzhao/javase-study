package com.tqz.javase.study.io.bytebufferio;

import com.tqz.javase.study.io.Constant;

import java.io.*;

/**
 * 字节缓冲流
 *
 * <p>把中转站变大
 *
 * @author tianqingzhao
 * @since 2023-05-24 21:01
 */
public class ByteBufferedIOTest2 {

    public static void main(String[] args) throws IOException {
        //创建流（输入流和输出流）
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(Constant.PATH1));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(Constant.PATH2));
        //使用流（输入流和输出流）
        byte[] buf = new byte[1024];
        int len = bis.read(buf);
        while (len != -1) {
            //写一个字节
            bos.write(buf, 0, len);
            //输出
            //System.out.println((char)n);
            //读一个字节
            len = bis.read(buf);
        }
        //手动刷新（输出缓冲区内容写入文件）
        //bos.flush();
        //关闭流（输入流和输出流）
        bis.close();
        bos.close();
    }
}
