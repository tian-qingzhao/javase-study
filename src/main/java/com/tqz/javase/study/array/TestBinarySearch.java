package com.tqz.javase.study.array;

/**
 * 功能：在有序数组中查询元素是否存在，存在返回索引，不存在返回-1
 * 技能：折半查找  二分法算法；
 * 查询的元素是num
 * 数组是arr
 * start:起始元素的索引
 * end:结尾元素的索引
 * mid：中间元素的索引
 * 当start<=end 一直循环下去
 * 结束条件1：找到了，提前结束循环
 * 结束条件2：start>end  正常结束
 *
 * @author tianqingzhao
 * @since 2023-05-09 20:30
 */
public class TestBinarySearch {
    public static void main(String[] args) {
        //给定一个数组
        int[] arr = {3, 12, 24, 36, 55, 68, 75, 88};

        //指定要查询的元素
        int num = 25;

        //采用二分法进行查询，返回索引
        int index = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            //计算mid的值
            int mid = (start + end) / 2;
            //获取mid对应的元素
            int midElem = arr[mid];
            //num和mid对应的元素进行比较
            if (num == midElem) {
                index = mid;
                break;
            } else if (num > midElem) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        //输出结果
        if (index != -1) {
            System.out.println("元素" + num + "存在，索引是" + index);
        } else {
            System.out.println("元素" + num + "不存在");
        }

    }
}