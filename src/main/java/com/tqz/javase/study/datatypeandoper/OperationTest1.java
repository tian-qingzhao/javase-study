package com.tqz.javase.study.datatypeandoper;

import java.util.Scanner;

/**
 * 功能：给定一个四位整数，得到并输出每位上的数字
 * 9527    9 5 2 7
 * 4673    4 6 7 3
 * 技能：算术运算符的应用  /  %取模（求余数）
 * 总结1：
 * 如果两个整数运算，结果还是整数
 * 如果两个操作数中有一个是double或者float，则另外一个操作数先转换为double或者float，再进行运算，
 * 结果不是整数类型；（自动类型转换）
 *
 * @author tianqingzhao
 * @since 2023-05-16 20:02
 */
public class OperationTest1 {

    public static void main(String[] args) {
        //简单理解一下/  %
        System.out.println(11 / 4); //2
        System.out.println(11 % 4); //3
        System.out.println(10.0 / 3);

        //给定一个四位整数
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个四位的整数");
        int num = input.nextInt();
        //int num = 8848;
        //得到每位上的数字
        int bit1 = num % 10;
        int bit2 = num / 10 % 10;// 952
        //int bit3 = num/100%10;  //95
        int bit3 = num % 1000 / 100;//  527  ---5
        int bit4 = num / 1000;
        //输出每位上的数字
        System.out.println(num);
        System.out.println(bit1);
        System.out.println(bit2);
        System.out.println(bit3);
        System.out.println(bit4);
    }
}
