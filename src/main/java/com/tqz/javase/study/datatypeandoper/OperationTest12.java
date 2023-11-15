package com.tqz.javase.study.datatypeandoper;

/**
 * 功能：获取两个数中较大的数并输出
 * 技能：条件运算符
 *
 * <p>
 * 1.条件运算符  表达式1？ 表达式2：表达式3
 * 2.运算符规则：表达式1为true，取表达式2的值，否则取表达式3的值
 * 3.唯一的三目运算符
 * 4.优先级别：仅高于赋值运算
 * 5.结合性：自右向左的结合性
 * 6.作用：替代简单的if-else语句
 *
 * @author tianqingzhao
 * @since 2023-05-17 19:57
 */
public class OperationTest12 {

    public static void main(String[] args) {
        //给定两个数
        int num1 = 100;
        int num2 = 50;
        int max = 0;
        //获取两个数中较大的数
		/*
		if(num1 > num2){
			max = num1;
		}else{
			max = num2;
		}*/
        max = num1 > num2 ? num1 : num2;
        //输出两个数中较大的数
        System.out.println(max);

        //结合性
        System.out.println(5 > 6 ? 5 : (7 == 8 ? 'a' : 'A'));
    }
}
