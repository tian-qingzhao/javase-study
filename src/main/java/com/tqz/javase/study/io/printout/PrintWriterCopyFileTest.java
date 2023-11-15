package com.tqz.javase.study.io.printout;

import com.tqz.javase.study.io.Constant;

import java.io.*;

/**
 * 功能：完成文件的复制（最终方案）
 * 技能：引入和使用缓冲字符流
 *
 * <p>输入流使用  BufferedReader readLine()  效率高 简单
 * 输出流使用 PrintWriter  BufferedWriter    简单 效率高
 *
 * @author tianqingzhao
 * @since 2023-05-27 0:24
 */
public class PrintWriterCopyFileTest {

    public static void main(String[] args) throws IOException {
        //创建字符输入和输出流
        BufferedReader br = new BufferedReader(new FileReader(new File(Constant.PATH1)));
        //BufferedWriter bw = new BufferedWriter(new FileWriter(Constant.PATH1));
        //PrintWriter pw = new PrintWriter(new FileWriter(Constant.PATH1));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(Constant.PATH2)));
        //使用字符输入和输出流
        String str = br.readLine();
        while (str != null) {
            //写一行
            pw.println(str);
            //再读一行
            str = br.readLine();
        }
        //关闭字符输入和输出流
        br.close();
        pw.close();
    }
}
