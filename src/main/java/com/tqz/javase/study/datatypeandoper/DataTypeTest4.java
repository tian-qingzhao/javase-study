package com.tqz.javase.study.datatypeandoper;

/**
 * 技能：掌握布尔（boolean）数据类型
 *
 * <p>1.布尔类型常量
 * true 真 对
 * false  假  错
 *
 * <p>2.布尔类型的变量
 * boolean
 *
 * <p>3.其他需要注意的内容
 * 1.布尔的使用场合：用于接收判断的结果
 * 2.在内存中占用1个位bit，不是一个字节byte
 *
 * @author tianqingzhao
 * @since 2023-05-15 20:08
 */
public class DataTypeTest4 {

    public static void main(String[] args) {
        //boolean
        boolean flag = true;
        System.out.println("flag=" + flag);
        flag = false;
        System.out.println("flag=" + flag);
        //flag = 3.14;

        //应用：用于接收判断的结果
        int n = 90;
        int m = 80;
        //boolean result = 70<80;
        boolean result = n < m;
        System.out.println("result=" + result);
    }
}
