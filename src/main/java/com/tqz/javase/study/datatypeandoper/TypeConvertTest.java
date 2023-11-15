package com.tqz.javase.study.datatypeandoper;

/**
 * 技能：基本数据类型的类型转换
 * 1.什么是类型转换
 * 在(赋值运算或算术)运算时，要求数据类型相同，否则要进行类型转换
 * <p>
 * 2.类型转换的类型
 * 基本数据类型的类型转换：
 * 数值类型（int short byte long float double char）和非数值类型(boolean),
 * 类型转换不涉及布尔类型
 * 引用数据类型的类型转换：父类和子类  Person  Student  Animal  Dog  以后再讲
 * <p>
 * 3.基本数据类型的类型转换的方向
 * byte,short,char---->int--->long--->float---->double
 * <p>
 * 4.算术运算中的转换
 * 两个操作数都转换为其中宽度大的类型，再运算
 * 3+'a'+3.14+5L====>
 * <p>
 * 3+'a' int  3+97=100
 * 100+3.14   100.0+3.14=103.14
 * 103.14+5L   103.14+5.0= 108.14
 * <p>
 * 5.赋值运算中的转换
 * 左=右  long n = 5+'a'+123L; 没有发生类型转换
 * 左<右   int n = 5+'a'+123L;  强制转换 (类型)  做手术
 * 左>右  double n = 5+'a'+123L; 自动转换
 * <p>
 * 6.特例
 * byte b = 12;
 * 把int赋给byte，short，char，如果数值在byte，short，char范围内，不用强制转换
 * b=(byte)129;
 * 如果超过了	byte，short，char范围，必须进行强制转换
 *
 * @author tianqingzhao
 * @since 2023-05-17 20:17
 */
public class TypeConvertTest {

    public static void main(String[] args) {
        //之前接触的类型转换
		/*
		System.out.println(10.0/3);// 10.0/3.0
		//int result = 10.0/3;
		double result = 10.0/3;
		System.out.println(result);
		char ch = 'a';
		System.out.println((int)ch);
		*/
        //System.out.println(5+true);
        //算术运算中的类型转换
        System.out.println(3 + 'a' + 3.14 + 5L);
        //赋值运算中的类型转换
        //double result = 3+'a'+3.14+5L;//左=右 没有转换
        int result = (int) (3 + 'a' + 3.14 + 5L);//左<右 强制转换
        //double result =  3+'a'+5L;//左>右 自动转换
        System.out.println(result);

        //特例
        //byte b = 12;
        byte b = (byte) 129;
        System.out.println(b);

        byte s = 5;
        //s = s+1;  // 这样会报错，可能会超出byte的范围，所以直接报错
        s += 1;//这个没有问题 内部强制转换
        System.out.println(s);
    }
}
