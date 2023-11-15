package com.tqz.javase.study.datatypeandoper;

/**
 * 技能：逻辑运算符的规则
 * 4.&和&&的联系和区别   |和||的联系和区别
 * 联系：
 * 运算规则相同:两个操作数都是true，结果是true，否则是false
 * 区别
 * 区别1：第一个操作数是false，能决定最终的结果，没有必要计算第二个操作数，此时&和&&有区别
 * & 还要计算第二个操作数
 * && 不计算第二个操作数 短路
 * 区别2：
 * & 不仅是逻辑运算符，还是位运算符
 * && 只是逻辑运算符
 *
 * <p>
 * 开发中常用的是短路逻辑运算符：
 *
 * @author tianqingzhao
 * @since 2023-05-17 19:01
 */
public class OperationTest9 {

    public static void main(String[] args) {
		/*
		//&的运算规则:两个操作数都是true，结果是true，否则是false
		System.out.println( true &  true); //true
		System.out.println( true &  false); //false
		System.out.println( false &  true); //false
		System.out.println( false &  false); // false

		System.out.println("========================");
		//&&的运算规则:两个操作数都是true，结果是true，否则是false
		System.out.println( true &&  true); //true
		System.out.println( true &&  false); //false
		System.out.println( false &&  true); //false
		System.out.println( false &&  false); // false
		*/
        //区别1：
        //第一个操作数是true，还不能决定最终的结果，就必须要计算第二个操作数，此时&和&&没有区别
        System.out.println(7 < 8 & 'a' == 'A');
        System.out.println(7 < 8 && 'a' == 'A');
        //第一个操作数是false，能决定最终的结果，没有必要计算第二个操作数，此时&和&&有区别
        //& 还要计算第二个操作数
        //&& 不计算第二个操作数 短路
        //短路与&&的效率高
        System.out.println(7 > 8 & 'a' == 'A');
        System.out.println(7 > 8 && 'a' == 'A');

        //区别2：
        System.out.println(7 & 8);
        //System.out.println(7&&8);

    }
}
