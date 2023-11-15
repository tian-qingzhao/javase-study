package com.tqz.javase.study.datatypeandoper;

/**
 * 功能：根据半径，计算并输出周长和面积
 * 技能：复习Java数据类型
 * 理解final常量
 * <p>
 * 问题1：如果要修改圆周率的精度，需要修改每个值，繁琐
 * 解决：定义一个变量pi，存储圆周率的值,减少了修改量
 * <p>
 * 问题2：因为pi是变量，所以可以中途修改pi的值，导致整个程序中pi的值不一致
 * 解决：使用final修饰pi  finally  最后的 最终的  不能再变化的
 * 使用final修饰的变量就成了常量
 * 3.14159   3  字面常量
 * pi  符号常量
 * <p>
 * 问题3：存在常量、变量、方法、类等，不能够通过名称直接判断类型
 * 解决：命名规范
 * testdatatype
 * 类：  TestDataType  驼峰命名法
 * 变量和方法  testDataType  testDataType()
 * 常量  TESTDATATYPE
 * 包  testdatatype
 *
 * @author tianqingzhao
 * @since 2023-05-16 19:25
 */
public class DataTypeTest6 {

    public static void main(String[] args) {
        //定义圆周率
        //double pi = 3.14159;
        final double pi = 3.14159;
        //给出半径
        double r = 3;

        //计算周长和面积
        //double pm = 2 * 3.14159 * r;
        //double area = 3.14159 * r * r;
        double pm = 2 * pi * r;

        //pi = 3.14; final修饰的不能被修改

        double area = pi * r * r;
        //输出周长和面试
        System.out.println("半径=" + r);
        System.out.println("周长=" + pm);
        System.out.println("面积=" + area);
    }
}
