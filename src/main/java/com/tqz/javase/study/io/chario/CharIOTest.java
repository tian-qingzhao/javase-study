package com.tqz.javase.study.io.chario;

import com.tqz.javase.study.io.Constant;

import java.io.*;

/**
 * 功能：完成文件的复制（输出）
 * 技能：引入和使用字符流
 *
 * <p>问题：使用字节流读写文件没有问题，显示中文字符有问题
 * 解决：使用字符流
 *
 * <p>字节流：InputStream OutputStream
 * 字符流：Reader Writer
 *
 * <p>总结
 * 1.字节流每次读取一个字节，字符流每次读取1个字符
 * 英文字符是1个字节
 * 汉字字符是2个字节（GBK）,3个字节（UTF-8）
 * 2.字符流如何判断是英文还是汉字
 * 英文：1个字节的最高位是0
 * 汉字：2个字节，先读的字节最高位是1
 *
 * @author tianqingzhao
 * @since 2023-05-24 19:56
 */
public class CharIOTest {

    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader(Constant.PATH1);
        Writer writer = new FileWriter(Constant.PATH2);

        int len = reader.read();

        while (len != -1) {
            writer.write(len);

            System.out.println(len + " " + (char) len);

            len = reader.read();
        }

        reader.close();
        writer.close();
    }
}
