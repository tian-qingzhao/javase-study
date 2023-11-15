package com.tqz.javase.study.datatypeandoper;

/**
 * '
 * 技能：位运算符1
 * &  |  ^  ~
 *
 * @author tianqingzhao
 * @since 2023-05-17 19:22
 */
public class OperationTest10 {

    public static void main(String[] args) {
        System.out.println(5 & 6);//4  // 两个数的二进制位都是1，就返回1，有一个是0就返回0
        System.out.println(5 | 6);//7 // 两个数的二进制位有一个是1就返回1，
        System.out.println(5 ^ 6);//3   // 异或，两个数的二进制位相同返回0，不相同返回1
        System.out.println(~6); //-7  // 取反

        //异或：可以理解为不进位的加法和不进位的减法
        //异或的特点：一个数据对另一个数据位异或两次，该数本身不变
        System.out.println(5 ^ 6 ^ 6);//5
    }
}
