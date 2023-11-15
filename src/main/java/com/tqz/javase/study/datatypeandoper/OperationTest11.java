package com.tqz.javase.study.datatypeandoper;

/**
 * 技能：位运算符2
 * << 左移运算符:每左移一位，相当于乘以2
 * >>  右移运算符:每右移一位，相当于除以2.最高位正数补0，负数补1
 * >>> 无符号右移运算符:不管正数还是负数，最高位一律补0，且没有无符号左移
 *
 * <p>无符号右移的作用：
 * 无符号右移在数据变换时非常重要。
 * 比如对byte b;做无符号右移，在众多散列、加密、压缩、影音媒体编码、序列化格式都会用到。
 * 如果没有这个无符号右移，就需要用更大的空间去做有符号右移。
 *
 * @author tianqingzhao
 * @since 2023-05-17 19:54
 */
public class OperationTest11 {

    public static void main(String[] args) {
        System.out.println(16 >> 1);
        System.out.println(16 >> 2);
        System.out.println(16 >> 3);
        System.out.println(16 >> 4);
        System.out.println(16 >> 5);

        System.out.println("-16 >> 1 ：" + (-16 >> 1));
        System.out.println("-16 >> 2 ：" + (-16 >> 2));
        System.out.println("-16 >> 3 ：" + (-16 >> 3));
        System.out.println("-16 >> 4 ：" + (-16 >> 4));
        System.out.println("-16 >> 5 ：" + (-16 >> 5));

        System.out.println("16 >>> 1 ：" + (16 >>> 1));
        System.out.println("16 >>> 2 ：" + (16 >>> 2));
        System.out.println("16 >>> 3 ：" + (16 >>> 3));
        System.out.println("16 >>> 4 ：" + (16 >>> 4));
        System.out.println("16 >>> 5 ：" + (16 >>> 5));

        //使用最快的方式计算2*8=？
        System.out.println(2 * 8);
        System.out.println(2 << 3);
    }
}
