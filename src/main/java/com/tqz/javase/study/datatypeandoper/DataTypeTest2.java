package com.tqz.javase.study.datatypeandoper;

/**
 * 技能：整型数据类型
 *
 * <p>1.整型常量
 * 十进制
 * 八进制
 * 十六进制
 *
 * <p>2.整型变量
 * byte   1
 * short  2
 * int    4
 * long   8
 * 在内存中分配的字节数不同，从而导致存储的数的范围不同
 *
 * <p>3.其他需要注意的内容
 * 默认的整型常量类型是int，如果超过了范围，增加l或者L后缀，建议L
 *
 * <p>
 * 2的10次方  1024  1000  10的三次方
 * 2的20次方  1024*1024 = 一百万  10的六次方
 * 2的22次方  4百万
 * 2的30次方  1024*1024*1024 = 1000*1000*1000 =10亿
 * 2的33次方   80亿
 * 10.24
 *
 * @author tianqingzhao
 * @since 2023-05-15 19:57
 */
public class DataTypeTest2 {

    public static void main(String[] args) {
        //byte
        byte b1;
        b1 = 15;
        System.out.println("b1=" + b1);//15
        b1 = 015;
        System.out.println("b1=" + b1);//13
        b1 = 0x15;
        System.out.println("b1=" + b1);//21
        //b1 = 145;//-128---127
        System.out.println("b1=" + b1);

        //short
        short sh = 123;
        System.out.println("sh1=" + sh);
        //sh = 123456;//-32768----32767
        System.out.println("sh1=" + sh);

        //int
        int i = 123456;
        System.out.println("i=" + i);

        //long
        long l1 = 123456;
        System.out.println("l1=" + l1);
        l1 = 2234567890L;
        System.out.println("l1=" + l1);
    }
}
