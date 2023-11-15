package com.tqz.javase.study.array;

/**
 * 功能：模拟文件复制
 * 技能：理解main方法的参数。
 *
 * <p>问题1：
 * ArrayUtil  public static void sort(double [] arr){}  形参
 * ArrayUtil.sort(scoreArr); 实参
 * public static void main(String [] args){}  形参
 * 实参如何传递，在哪里传递
 * 程序的入口，谁来调用main()
 * javac Copy.JAVA
 * java Copy  abc  123  true
 * 问题2：给main方法传递参数的意义
 * copy Copy.java  c:\ta13.java
 *
 * @author tianqingzhao
 * @since 2023-05-08 21:44
 */
public class Copy {

    public static void main(String[] args) {
        /*
		//形参数组的长度
		System.out.println(args.length);
		//形参数组的各个元素
		for(String arg : args){
				System.out.println(arg);
		}
		*/
        System.out.println("源文件名称：" + args[0]);
        System.out.println("目标文件名称：" + args[1]);
        System.out.println("使用Java IO流功能完成文件复制");
    }
}
