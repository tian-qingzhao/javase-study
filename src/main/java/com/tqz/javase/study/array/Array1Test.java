package com.tqz.javase.study.array;

import java.util.Scanner;

/**
 * 第一次学习数组。
 *
 * <p>使用数组给10个学生分数求平均分。
 *
 * <p>数组的内存分配：
 * 栈内存 stack：存放数组名、局部变量，没有默认值，方法执行完毕立刻释放空间，先进后出的结构，比如螺盘子。
 * 堆内存 heap： 存放数组的每个元素，每个元素都有默认值，方法执行完毕后不会立刻释放资源，
 * 由垃圾回收器负责回收，程序员不用处理，但时间不确定。
 * int的值存放在栈内存，int[]的值存放在堆内存。
 * main方法执行完之后栈里面开辟的空间会立马消失，int[] scoreArr也不会指向堆里面的每个元素了，
 * 堆里面的数据还不会消失。
 *
 * <p>数组是什么？
 * 数组是相同数据类型的有序集合，会在内存中开辟一块连续的空间，每个空间相当于之前的一个变量，称为数组的元素(element)，
 * 元素的表示：数组名[下标或者索引]，索引从0开始，
 * 每个数组都有默认值，比如int是0，double是0.0，boolean是false，String是null。
 * 对于一个数组来说，类型是唯一的，length是数组的长度。
 *
 * <p>数组的特点：
 * 1.在内存中开辟一块连续的空间
 * 2.每个数组元素都有默认值
 * 3.数组的长度是固定的，不能变化，如果需要变化需要分配更大的空间。
 *
 * <p>数组的语法操作：
 * 1.声明数组：int[] scoreArr; 在栈中声明了一个数组变量，值不确定，还没有分配空间
 * 2.给数组分配空间：scoreArr = new int[len]; 在堆内存中分配10个连续的空间，每个元素是int类型，4个字节，默认值是0，
 * 并且把首地址赋值栈内存的scoreArr。引用类型的默认值都是null。
 * 3.合并声明数组、分配内存空间：int[] scoreArr = new int[len];
 * 4.合并声明数组、分配内存空间、静态初始化，合并赋值的时候不能声明数组的长度。
 * 给出数组的初始化值，由系统决定长度。
 * int[] scoreArr = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
 * 或者 `=` 右边不用再声明类型，也是静态初始化
 * int[] scoreArr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
 * 5.动态初始化，给出数组的长度，由系统给出初始化值。
 * scoreArr[0] = 10, scoreArr[1] = 20, ..., scoreArr[9] = 100
 *
 * @author tianqingzhao
 * @since 2023-05-06 20:49
 */
public class Array1Test {

    public static void main(String[] args) {
        int num = 10; // 值存放在栈内存

        int len = 10;
        int[] scoreArr;
        scoreArr = new int[len]; // 值存放在堆内存

        Scanner input = new Scanner(System.in);
        for (int i = 0; i < len; i++) {
            System.out.println("请输入第 " + (i + 1) + " 个学生的分数");
            // 动态初始化
            scoreArr[i] = input.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += scoreArr[i];
        }

        for (int i = 0; i < len; i++) {
            System.out.println("第 " + (i + 1) + "个学生的分数：" + scoreArr[i]);
        }

        int avg = sum / len;
        System.out.println("总分：" + sum + ",平均分：" + avg);
    }
}
