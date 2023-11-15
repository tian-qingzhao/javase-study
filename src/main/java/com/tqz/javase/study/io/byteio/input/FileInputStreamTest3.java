package com.tqz.javase.study.io.byteio.input;

import com.tqz.javase.study.io.Constant;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 功能：复制文件的前一半：读取文件并输出
 *
 * <p>缺点：没有进行异常处理
 *
 * <p>问题1：保存文件时编码的区别
 * ansi：本地码  大陆就是gbk，台湾就是Big5
 * gb2312 gbk   gb18030  英文1个字节  汉字两个字节
 * utf-8：英文一个字节，汉字3个字节
 * unicode：每个字符2个字节
 *
 * @author tianqingzhao
 * @since 2023-05-23 21:13
 */
public class FileInputStreamTest3 {

    public static void main(String[] args) throws IOException {
        InputStream is = null;
        try {
            //1.创建一个输入流
            is = new FileInputStream(Constant.PATH1);
            //2.使用输入流读取文件并输出
            //2.1创建一个中转站（水桶）
            byte[] buf = new byte[1024];
            //2.2读数据并输出
            //读取数据到buf
            int len = is.read(buf);//读数据到buf，len是本次读取的字节数
            while (len != -1) {
                //输出
                //System.out.println(len);
                //System.out.println(len+"  "+new String(buf));
                System.out.println(new String(buf, 0, len));
                //读取数据到buf
                len = is.read(buf);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭输入流
            if (is != null) {
                is.close();
            }
        }
    }
}
