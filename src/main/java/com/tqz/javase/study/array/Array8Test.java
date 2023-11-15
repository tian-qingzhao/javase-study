package com.tqz.javase.study.array;

/**
 * 冒泡排序。
 *
 * <p>排序算法很多，冒泡排序，选择排序，插入排序，是三种最基本最简单的排序算法，效率最低
 *
 * <p>冒泡排序的算法
 * 1.整个数列分成两部分：前面是无序数列，后面是有序数列
 * 2.初始状态下，整个数列都是无序的，有序数列是空
 * 3.如果一个数列有n个元素，则至多需要n-1趟循环才能保证数列有序
 * 4.每一趟循环可以让无序数列中最大数排到最后，（也就是说有序数列的元素个数增加1）
 * 5.每一趟循环都从数列的第一个元素开始进行比较，依次比较相邻的两个元素，比较到无序数列的末尾即可（而不是数列的末尾）
 * 6.如果前一个大于后一个，交换
 *
 * @author tianqingzhao
 * @since 2023-05-08 20:19
 */
public class Array8Test {

    public static void main(String[] args) {
        int[] arr = {35, 102, 85, 46, 89, 12, 78};
        System.out.println("排序后：");
        for (int i : arr) {
            System.out.print(i + "\t");
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("排序后：");
        for (int i : arr) {
            System.out.print(i + "\t");
        }

    }
}
