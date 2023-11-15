package com.tqz.javase.study.io.printout;

import com.tqz.javase.study.io.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

/**
 * 功能：输出各种类型数据到文件
 * 技能：PrintStream
 *
 * <p>System.out只是PrintStream类的一个实例而已
 *
 * <p>println():可以将各种类型的数据（基本数据类型、引用数据类型）直接写入文件
 * 操作简单
 *
 * <p>
 * 不关闭也可以写入内容，底层没有使用缓冲区
 *
 * @author tianqingzhao
 * @since 2023-05-27 0:03
 */
public class PrintStreamTest {

    public static void main(String[] args) throws FileNotFoundException {

        //PrintStream ps = System.out;
        PrintStream ps = new PrintStream(new FileOutputStream(new File(Constant.PATH1)));
        ps.println(12);
        ps.println(3.14);
        ps.println('A');
        ps.println(true);

        ps.println("test print stream");
        ps.println(new Date());

        //FileOutputStream os = new FileOutputStream(new File(Constant.PATH1));

//		System.out.println(12);
//		System.out.println(3.14);
//		System.out.println('A');
//		System.out.println(true);
//
//		System.out.println("bjsxt");
//		System.out.println(new Date());

        //ps.close();

    }
}
