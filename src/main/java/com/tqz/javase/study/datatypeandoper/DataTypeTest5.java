package com.tqz.javase.study.datatypeandoper;

/**
 * 技能：掌握字符数据类型
 * 1.字符常量：使用单引号括起来的一个字符
 * 'A','a','5','学'  ' '
 * "学"  '尚学堂'  ''
 * 1.单引号而不是双引号（字符串）
 * 2.一个字符，不是多个字符，不是0个字符
 * 3.字符：Unicode字符 可以是汉字，日语，韩语
 * 4.一个字符常量在内存中占据2个字节
 * 2.字符变量
 * char   charactor
 * 3.其他
 * 1.理解转义字符  是一个字符，\开始
 * 2.小技能：如何原样输出\n
 * 3.char和int的区别和联系
 * char类型常量在内存中存储的就是该字符的Unicode编码值，A--65   a---97
 * 在一定范围内，字符类型和整型可以通用
 * 区别
 * 1.分配的空间不同   int  4  char  2
 * 2.数值的范围不同   int的范围更大  ，并且char只有正数没有负数
 *
 * @author tianqingzhao
 * @since 2023-05-15 20:49
 */
public class DataTypeTest5 {

    public static void main(String[] args) {
        //认识字符类型
        char ch = 'a';
        System.out.println("ch=" + ch);
//        ch = '学';
        System.out.println("ch=" + ch);
        //ch = 'ぁ';
        ch = ' ';
        System.out.println("ch=" + ch + "end");
        //转义字符
        //char ch2 = '\n';
        char ch2 = '\t';
        System.out.println("ch2=" + ch2 + "end");
        System.out.println("Hello\nJava");
        System.out.println("Hello\\nJava");
        System.out.println("Hello\\\nJava");
        System.out.println("Hello\\\\nJava");
        //char和int的区别和联系
        //char ch3 = 'a';
        char ch3 = 97;
        char ch4 = 'A';
        System.out.println("ch3=" + ch3);
        System.out.println("ch3=" + (int) ch3);
        System.out.println("ch4=" + ch4);
        System.out.println(ch3 - 32);
        System.out.println((char) (ch3 - 32));
    }
}
