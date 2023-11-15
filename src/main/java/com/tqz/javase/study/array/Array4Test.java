package com.tqz.javase.study.array;

/**
 * 数组的查询提取方法以及理解形参是数组的内存调用过程。
 *
 * <p>问题：scoreArr和arr数组有联系和区别
 * 1.区别：scoreArr在main方法中定义的变量，作用范围是main，
 * arr在search方法中定义的变量，作用范围是search，作用范围互不冲突。
 * 2.联系：scoreArr是实参，arr是形参
 * 方法调用时将实参付给形参 arr = scoreArr;
 * 导致arr和scoreArr都指向堆内存中同一个数组，
 * 在search中操作arr就相当于在main中操作scoreArr。
 *
 * <p>int、double等基本数据类型并不会，因为基本数据类型是直接在栈内存分配的空间，不会再堆内存分配空间，
 * 每个方法都拥有自己的栈空间，所以基本数据类型在不同的方法赋值，并不会影响原来方法的值。
 *
 * @author tianqingzhao
 * @since 2023-05-07 19:29
 */
public class Array4Test {

    public static void main(String[] args) {
        // 使用数组存储10个学生的分数
        int[] scoreArr = {75, 87, 56, 45, 89, 100, 76, 34, 89, 97};
        // 获取分数的76的学生的索引（第一个）
        int elem = 45;
        // !!!!!调用方法，获取结果
        int index = search(scoreArr, elem);
        if (index == -1) {
            System.out.println("数组中不存在该值：" + elem);
        } else {
            System.out.println(elem + "在数组中的索引：" + index);
        }
    }

    /**
     * 形参：要查询的分数，要查询的数组
     * 返回值：索引
     */
    public static int search(int[] arr, int elem) {
        // 默认不存在
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (elem == arr[i]) { // 找到了
                // 获取索引
                index = i;
                // 找到了，后续元素不用再比较
                break;
            }
        }
        // 返回索引
        return index;
    }
}
