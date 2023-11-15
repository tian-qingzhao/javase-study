package com.tqz.javase.study.datatypeandoper;

/**
 * 功能：表示一个人年龄的变化；表示两个人体重
 * 技能：认识数据类型，认识常量和变量
 *
 * <p>思考：年龄和体重会变化，使用变量存储
 * 年龄是整数类型；体重应该是浮点数类型
 *
 * <p>注意：一个变量定义一次，可以多次使用
 * 理解=，不是数学中的等于，代表赋值
 *
 * <p>总结1.认识数据类型常量变量
 * 数据类型：int  double
 * 变量  age  weight1  weight2
 * 常量值   15  16  70.5
 *
 * <p>总结2：在内存中到底发生了什么
 * 变量其实代表内存中一块空间
 * 变量          						房间
 * 变量名        age    weight1        房间号
 * 变量类型      int     double        房间类型（标准间，三人间 ，总统间）
 * 变量的值      15      70.5			房间中客人
 *
 * <p>总结3：变量如何定义
 * int age = 15;
 * 变量的类型   变量名  = 变量值;
 * 可以一次定义多个变量
 * 可以定义变量的时候赋值，也可以分开进行
 * 方法中定义的变量没有默认值
 *
 * @author tianqingzhao
 * @since 2023-05-15 19:56
 */
public class DataTypeTest1 {

    public static void main(String[] args) {
        //表示一个人年龄的变化()
        int age = 15;
        System.out.println("age=" + age);
        //int age = 16;
        age = 16;
        System.out.println("age=" + age);

        //表示两个人体重
        double weight1 = 70.5;
        System.out.println("weight1=" + weight1);
        double weight2 = 75.5;
        //第二个人的体重比第一个人重10公斤  70.5+10=80.5
        weight2 = weight1 + 10;
        System.out.println("weight2=" + weight2);

        //变量的其他定义方式
        double price1, price2 = 0;
        price1 = 15.5;
        System.out.println("price1=" + price1);
        System.out.println("price2=" + price2);
    }
}
