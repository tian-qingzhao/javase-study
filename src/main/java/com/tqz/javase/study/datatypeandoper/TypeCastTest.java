package com.tqz.javase.study.datatypeandoper;

/**
 * 技能：基本数据类型的类型转换
 * 1.什么是类型转换
 * 在赋值运算或算术运算时，要求数据类型相同，否则要进行类型转换
 * <p>
 * 2.类型转换的类型
 * 基本数据类型的类型转换：
 * 数值类型（int short byte long float double char）和非数值类型(boolean),
 * 类型转换不涉及布尔类型
 * 引用数据类型的类型转换：父类和子类  Person  Student  Animal  Dog  以后再讲
 * <p>
 * 3.基本数据类型的类型转换的方向
 * byte,short,char----int---long---float----double
 * <p>
 * 4.算术运算中的转换
 * 3+'a'+5L====>3L+97L+5L===>105L
 * 先扫描整个表达式，发现宽度最大的类型，所有的数据都转换成该类型，再运算
 * 3+'a'+5L+3.14==>3.0+97.0+5.0+3.14====>
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
 * @since 2023-05-17 20:14
 */
public class TypeCastTest {

    public static void main(String[] args) {
        //1.算术运算的类型转换
        System.out.println(3 + 'a' + 5L);//3L+97L+5L
        System.out.println(3 + 'a' + 5L + 3.14);//3.0+97.0+5.0+3.14

        //2.赋值运算的类型转换
        //2.1自动转换
        byte b1 = 10;
        System.out.println("b1=" + b1);
        int n1 = b1;
        System.out.println("n1=" + n1);
        //2.2强制转换
        int n2 = 270;
        System.out.println("n2=" + n2);
        byte b2 = (byte) n2;
        System.out.println("b2=" + b2);
        //2.3注意
        //int n3 = (int)3+'A'+3.78;//错误
        int n3 = (int) (3 + 'A' + 3.78);//正确
        System.out.println(n3);

        //3.特例
        byte b4 = 12;
        System.out.println(b4);
        b4 = (byte) 129;
        System.out.println(b4); // 做手术 去掉int的高3个字节，保留低一个字节，也就是只剩下二进制的后八位了

        short s1 = 1;   //1
        //s1=s1+1;     //2
        s1 += 1;       //3  扩展的赋值运算符其实隐含了一个强制类型转换。
		/*
		s += 1;
			不是等价于 s = s + 1;
			而是等价于 s = (s的数据类型)(s + 1);
		*/
        System.out.println(s1);


    }
}
