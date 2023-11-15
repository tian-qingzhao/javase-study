package com.tqz.javase.study.datatypeandoper;

/**
 * 技能：掌握算术运算符
 *
 * <p>总结1：+
 * 正号
 * 加号
 * 字符串相连
 * 单目双目运算符
 * 结合性
 *
 * <p>总结2：优先级别
 * （ + - 加减 ）<(* / %乘 除 取模) < (++  --)   <(+ - 正 负) < 小括号
 *
 * <p>总结3：++  --
 * n++; ++n;作用是相同的，都相当于n = n +1;
 * 如果n++ ++n是一条单独的语句，两者没有任何区别，都相当于n = n +1;
 * <p>
 * 如果n++ ++n不是一条单独的语句，此时有区别
 * x++:先运算，后++
 * ++x; 先++，后运算
 * 注意：变量可以自增自减，常量不可以
 *
 * @author tianqingzhao
 * @since 2023-05-16 20:02
 */

public class OperationTest2 {

    public static void main(String[] args) {
        //+
        System.out.println(+5);//正号  单目运算符  5
        System.out.println(5 + 6);//加号  双目运算符  11
        System.out.println(5 + 6 + 7);//先计算5+6   结合性 自左向右  18
        System.out.println("abc" + 1 + 2); //字符串相连   abc12  "abc1"+2  "abc12"
        System.out.println(1 + 2 + "abc"); //3abc  3+"abc" ---"3abc"
        System.out.println("abc" + (1 + 2));
        //System.out.println("age="+age);
        System.out.println("==============");
        //++ 自增
        int n = 5;
        //n = n +1;
        //n++;
        ++n;
        System.out.println(n);

        int x = 5;
        int y;
        //y = 5 + x++;
        //y = 5+ x;
        //x++;
        //System.out.println("x="+x+",y="+y);//x=6 y=10;

        //y = 5+ ++x;
        ++x; //6
        y = 5 + x; //11
        System.out.println("x=" + x + ",y=" + y);//x=6  y=11
    }
}
