package com.tqz.javase.study.datatypeandoper;

/**
 * 功能：交换手中两张扑克牌
 * 技能：赋值运算符 =
 *
 * <p>思路1：直接交换不可以
 * 思路2：引入中间变量temp
 *
 * <p>赋值运算符
 * 1.双目运算符
 * 2.结合性 ：自右向左
 * 3.优先级别：优先级别最低的
 *
 * @author tianqingzhao
 * @since 2023-05-16 20:47
 */
public class OperationTest3 {

    public static void main(String[] args) {
        //手中两张牌
        int left = 5; //i++  +5
        int right = 10;
        //展示一下交换前手中牌
        System.out.println("交换前：left=" + left + ",right=" + right);
        //交换
        //left = right;
        //right = left;
        int temp;
        temp = left;
        left = right;
        right = temp;
        //展示一下交换后手中牌
        System.out.println("交换后：left=" + left + ",right=" + right);

        //理解结合性
        int y, z;
        int x = y = z = 5;
        System.out.println(x + "  " + y + "  " + z);
        //x = 5+6*6/12;
    }
}
