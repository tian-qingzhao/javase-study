package com.tqz.javase.study.datatypeandoper;

/**
 * 功能：计算三个学生分数之和并输出
 * 技能：理解扩展赋值运算符
 * 基本赋值运算符  =
 * 扩展赋值运算符： +=  -= *= /= %=（和五个算术运算符结合）
 *
 * @author tianqingzhao
 * @since 2023-05-16 21:05
 */
public class OperationTest4 {

    public static void main(String[] args) {
        //给定三个分数
        int score1 = 90;
        int score2 = 80;
        int score3 = 100;
        //求和
        //int sum = score1+score2+score3;
        int sum = 0;
        //sum = sum + score1;
        //sum = sum + score2;
        //sum = sum + score3;
        //推荐使用该方式
        //1.简单
        //2.编译后的结果执行速度快
        //3.可读性差（见多不怪）
        sum += score1;
        sum += score2;
        sum += score3;
        //输出和
        System.out.println("sum=" + sum);

        int m = 5;
        //m = m * 5+6;//31
        //m = m * (5+6);//55
        m *= 5 + 6; // 等号后面的会优先执行
        System.out.println(m);
    }
}
