package com.tqz.javase.study.datatypeandoper;

/**
 * 功能：给定3个无序数，进行从小到大排序并输出
 * 技能：关系运算符   排序的算法
 *
 * <p>
 * 排序离不开比较（使用关系运算符）和交换（引入中间变量）
 * 算法：
 * 1.第一个数和第二个数比较，如果第一个大于第二个，交换
 * 2.第一个数和第三个数比较，如果第一个大于第三个，交换
 * 此时可以保证第一个数最小
 * 3.第二个数和第三个数比较，如果第二个大于第三个，交换
 * num1  num2  num3
 * 30     10     20
 * 10     30     20
 * 10     30     20
 * 10     20     30
 * 10     20       30
 * 注意：变量的作用范围，可能是当前{}，当前方法，当前类
 *
 * <p>总结：
 * 1.关系运算的结果一定是boolean值
 * 2.==和=的区别
 * 3.优先级别   (==  !=)  < (>  >= <  <=)
 * 4.==  != 是所有（基本和引用）数据类型都可以使用
 * >  >= <  <= 针对数值类型（int double  char）
 *
 * @author tianqingzhao
 * @since 2023-05-16 21:09
 */
public class OperationTest6 {

    //int temp;
    public static void main(String[] args) {
        //1.给定3个无序数
        int num1 = 300;
        int num2 = 1000;
        int num3 = 20;
        //2.输出排序前的结果
        System.out.println("排序前" + num1 + "  " + num2 + "  " + num3);
        //3.进行从小到大排序
        //3.1.第一个数和第二个数比较，如果第一个大于第二个，交换
        int temp;
        boolean flag = num1 > num2;
        if (flag) { // true  == true    true
            //int temp;
            temp = num1;
            num1 = num2;
            num2 = temp;
        }
        //3.2.第一个数和第三个数比较，如果第一个大于第三个，交换
        flag = num1 > num3;
        if (flag) {
            //int temp;
            temp = num1;
            num1 = num3;
            num3 = temp;
        }
        //3.3.第二个数和第三个数比较，如果第二个大于第三个，交换
        if (num2 > num3) {
            //int temp;
            temp = num2;
            num2 = num3;
            num3 = temp;
        }
        //4.输出排序后的结果
        System.out.println("排序后" + num1 + "  " + num2 + "  " + num3);

        //理解优先级别
        System.out.println(5 < 6 == 'A' > 'a'); // true == 'A'>'a'  true == false  false
        System.out.println((5 < 6) == ('A' > 'a'));//结果相同，可读性高
        System.out.println(true == false);
        //System.out.println(true > false);

    }
}
