package com.tqz.javase.study.datatypeandoper;

/**
 * 技能：逻辑运算符的规则
 *
 * <p>1.逻辑运算符有哪些
 * &  逻辑与
 * |  逻辑或
 * ^  逻辑异或
 * !  逻辑非
 * &&  短路与
 * ||  短路或
 * 逻辑运算的操作数和运算结果都是布尔值
 *
 * <p>2.逻辑运算符的运算规则
 *
 * <p>3.逻辑运算符的优先级别
 * 非 > 与 > 异或 > 或
 * 学过的单目运算符： + - ++ --  ！
 *
 * <p>4.&和&&的联系和区别   |和||的联系和区别
 *
 * @author tianqingzhao
 * @since 2023-05-17 19:00
 */
public class OperationTest8 {

    public static void main(String[] args) {
        //&的运算规则:两个操作数都是true，结果是true，否则是false
		/*
		System.out.println( true &  true); //true
		System.out.println( true &  false); //false
		System.out.println( false &  true); //false
		System.out.println( false &  false); // false
		//System.out.println( 7<8 &  'A'=='A');
		*/
        //|的运算规则:两个操作数都是false，结果是false，否则是true
        //如果两个操作数中只要有一个是true，结果就是true
		/*
		System.out.println( true |  true); //true
		System.out.println( true |  false); //true
		System.out.println( false |  true); //true
		System.out.println( false |  false); //false
		*/
        //^的运算规则:两个操作数相同，结果是false，不同结果是true
		/*
		System.out.println( true ^  true); //false
		System.out.println( true ^  false); //true
		System.out.println( false ^  true); //true
		System.out.println( false ^  false); //false
		*/
        // !的运算规则:去反
        System.out.println(!true); //false
        System.out.println(!false); //true

        System.out.println(false | true & !false);
        //false | true & true  先计算 !false
        //false |  true  在计算 true & true
        //true 最后计算 false | true
    }
}
