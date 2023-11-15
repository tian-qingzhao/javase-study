package com.tqz.javase.study.io.other;

import com.tqz.javase.study.io.Constant;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 1.编码和解码
 * 编码：OutputStreamWriter  str2.getBytes("gbk");
 * 解码：InputStreamReader   new String(arr, "utf-8");
 * <p>
 * 2.只有字符流才涉及编码的问题；字节流没有编码问题
 * 3.哪些字符流可以指定编码
 * OutputStreamWriter
 * InputStreamReader
 * PrintStream和 PrintWriter 操作简单，底层使用的还是转换流OutputStreamWriter
 * FileReader和FileWriter没有提供指定编码的功能，只能按照默认的本地编码进行操作
 *
 * @author tianqingzhao
 * @since 2023-05-27 18:59
 */
public class EncoderDecoderTest {

    public static void main(String[] args) throws Exception {

        //1.向一个文件中写入两个汉字：中国
        File file = new File(Constant.PATH1);
        OutputStream os = new FileOutputStream(file);
        //Writer writer = new OutputStreamWriter(os);//默认编码是ansi（gbk）
        Writer writer = new OutputStreamWriter(os, StandardCharsets.UTF_8);//指定编码 utf-8
        BufferedWriter bw = new BufferedWriter(writer);

        bw.write("中国");

        bw.close();

        //2.从该文件中读取内容(采用正确的编码)
        System.out.println(file.length());
        InputStream is = new FileInputStream(Constant.PATH1);
        //InputStreamReader reader = new InputStreamReader(is);//默认的编码是ansi(GBK)
        InputStreamReader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(reader);
        String str = br.readLine();

        br.close();

        System.out.println(str);

        //3.采用错误的编码
        InputStream is2 = new FileInputStream(Constant.PATH1);
        //InputStreamReader reader = new InputStreamReader(is);//默认的编码是ansi(GBK)
        InputStreamReader reader2 = new InputStreamReader(is2);
        BufferedReader br2 = new BufferedReader(reader2);
        String str2 = br2.readLine();
        br2.close();
        System.out.println(str2);

        //String----字节数组
        //byte [] arr = str.getBytes();////默认的编码是ansi(GBK)
        byte[] arr = str2.getBytes("gbk");
        //字节数组---->String
        str2 = new String(arr, StandardCharsets.UTF_8);
        System.out.println(str2);

        PrintWriter pw = new PrintWriter(file, "utf-8");
        PrintStream ps = new PrintStream(file, "utf-8");

    }
}
