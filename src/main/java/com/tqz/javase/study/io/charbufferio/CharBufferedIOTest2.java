package com.tqz.javase.study.io.charbufferio;

import com.tqz.javase.study.io.Constant;
import sun.security.action.GetPropertyAction;

import java.io.*;
import java.security.AccessController;

/**
 * 功能：完成文件的复制（输出）
 * 技能：引入和使用缓冲字符流
 *
 * <p>缺点：中转站要么是一个字符，要么是一个字符数组，更希望一行行读取的共
 * 解决：二进制文件没有行的概念，所有缓冲字节流没有提供该功能
 * 文本文件有行的概念，所有缓冲字符流提供了该功能
 * 读取文本文件比读取二进制文件多了一种方式：按行读取
 *
 * <p>优点：简化了操作，可以直接按行读取，不需要程序员编码实现按行读取
 *
 * <p>总结
 * 1.readLine()的底层实现
 * readLine()本质上还是通过read()方法来实现的
 * 一个个字符的读取，遇到换行符，输出内容
 * 可以使用StringBuffer，也可以使用字符数组
 * 2.newLine()的底层实现
 * 不同操作系统的换行符是不同的，java是读取对应的环境变量line.separator获取对应的换行符
 *
 * @author tianqingzhao
 * @since 2023-05-24 21:18
 */
public class CharBufferedIOTest2 {

    public static void main(String[] args) throws IOException {
        // 根据环境变量获取换行符，window换行符是/r/n，linux是/n
        String s = AccessController.doPrivileged(
                new GetPropertyAction("line.separator"));
        System.out.println(s);

        //创建字符输入和输出流
        BufferedReader br = new BufferedReader(new FileReader(Constant.PATH1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(Constant.PATH2));

        // 按行读取
        String str = br.readLine();
        while (str != null) {
            bw.write(str);
            bw.newLine();

            str = br.readLine();
        }

        //关闭字符输入和输出流
        br.close();
        bw.close();
    }

}
