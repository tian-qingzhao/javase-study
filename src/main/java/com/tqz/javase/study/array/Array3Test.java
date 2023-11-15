package com.tqz.javase.study.array;

/**
 * 按照索引查询数组的内容，以及根据内容查询数组的索引。
 *
 * <p>数组按照索引查询数据，效率最高；不管查找第几个元素，花费的时间是一样的。
 * 原理：分配连续的空间，且每个元素的空间大小是相同的，
 * 所以指定索引的元素位置=数组的起始位置+每个元素的大小*索引。
 * 用一张图来理解一下：
 * 声明的数组：int[] scoreArr = {75, 87, 56, 45, 89, 100, 76, 34, 89, 97};
 * 值：       75     87   56     45    89   100   76    34     89    97
 * 内存地址：1012  1016  1020   1024  1028  1032  1036  1040  1044  1048
 * 第一个元素，索引为0：1012 + 0*4 = 1024，第8个元素，索引为7：1012 + 7*4 = 1040 。
 *
 * <p>数组按照内容查询数据，效率低下；一般需要从第一个元素逐次比较，直到找到位置；
 * 或者比较到数组的最后一个元素也没有找到，则确认无该元素。
 * 如果数组的数据是大小有序的，就可以提高查询的效率，采用折半查询效率提高。
 *
 * @author tianqingzhao
 * @since 2023-05-07 18:46
 */
public class Array3Test {

    public static void main(String[] args) {
        //使用数组存储10个学生的分数，静态初始化
        int[] scoreArr = {75, 87, 56, 45, 89, 100, 76, 34, 89, 97};
        //获取第8个学生的分数
        int position = 8;
        int score = scoreArr[position - 1];
        System.out.println("第" + position + "个学生的分数是：" + score);

        //获取分数的76的学生的索引（找到第一个相同的就算找到了）
        int index = -1;
        int elem = 101;
        for (int i = 0; i < scoreArr.length; i++) {
            if (elem == scoreArr[i]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("数组中不存在该值：" + elem);
        } else {
            System.out.println(elem + "在数组中的索引：" + index);
        }
    }
}
