package com.tqz.javase.study.datatypeandoper;

/**
 * 技能：掌握浮点数据类型
 *
 * <p>1.浮点型常量
 * 小数形式
 * 科学计数法  3.14e100
 *
 * <p>2.浮点型变量
 * float     4
 * double    8
 * 共同点：都是表示浮点类型
 * 不同点：内存中分配的字节数不同，导致存储的数据的范围不同，精度不同
 *
 * <p>3.其他要注意的内容
 * 1.浮点型常量默认类型double，如果想表示为float，添加后缀F或者f
 * 2.float在内存中占据4个字节，int在内存中占据4个字节，从而两种类型表示的范围应该是相同的？
 * 不相同！！！
 * 表示的方法是不同的
 * int 整数类型  10进制直接转换成二进制，存入即可
 * float  浮点类型  4个字节分为前后两部分，前面存储基数，后一部分存放的是指数100
 * 前一部分决定精度，后一部分用来决定范围
 * 3.浮点型性数据不建议进行比较
 * = 赋值
 * ==比较，是否相等
 *
 * @author tianqingzhao
 * @since 2023-05-15 20:01
 */
public class DataTypeTest3 {

    public static void main(String[] args) {
        //double
        double d1 = 3.14;
        System.out.println(d1);
        d1 = 3.14e5;
        System.out.println(d1);

        //float
        float height = 1.76F;
        System.out.println(height);

        double d2 = 1.76;
        System.out.println(height == d2);

        double d3 = 3.14E10;
        System.out.println(d3);
    }
}
