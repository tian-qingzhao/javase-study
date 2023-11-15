package com.tqz.javase.study.io.printout;

import com.tqz.javase.study.io.Constant;

import java.io.*;
import java.util.Date;

/**
 * 打印流 {@link PrintWriter} 测试
 *
 * <p>
 * 注意
 * 1.PrintWriter给用户提供了更多的方便的构造方法
 * 2.可以设置自动刷新，遇到换行自动刷新
 *
 * @author tianqingzhao
 * @since 2023-05-27 0:06
 */
public class PrintWriterTest {

    public static void main(String[] args) throws IOException {
        //创建PrintWriter对象
        //默认路径：当前项目
//        PrintWriter pw = new PrintWriter(new FileWriter(new File(Constant.PATH1)));
//        PrintWriter pw2 = new PrintWriter(Constant.PATH1);
//        PrintWriter pw3 = new PrintWriter(new File(Constant.PATH1));
//        PrintWriter pw4 = new PrintWriter(new FileWriter(new File(Constant.PATH1)));
//        PrintWriter pw5 = new PrintWriter(new FileOutputStream(new File(Constant.PATH1)));
//        PrintWriter pw6 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File(Constant.PATH1))));
        PrintWriter pw = new PrintWriter(new FileWriter(new File(Constant.PATH1)), true);
        //使用PrintWriter对象
        pw.println(12);
        pw.println(3.14);
        pw.println('A');
        pw.println(true);

        pw.print("test print writer");
        pw.print(new Date());
        // println()方法也会刷新
        pw.println();
        //pw.flush();
        //关闭PrintWriter对象
        //pw.close();
    }
}
