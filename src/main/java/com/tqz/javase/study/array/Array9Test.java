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
 * 6.如果前一个大于后一个，就进行交换
 *
 * <p>缺点1：每一趟比较都要比较到数组的最后，没有必要，只要比较到无序数列的最后即可
 * for(int j=0;j<scoreArr.length-1;j++){        }
 * i      j<?
 * 0      <6
 * 1      <5
 * 2      <4
 * 3      <3
 * i      j<6-i scoreArr.length-1-i
 * 解决：j<scoreArr.length-1 修改为 j<scoreArr.length-1-i
 * 缺点2：不管是否有序，都要进行n-1趟循环
 * 如何判断有序：比较了一趟，没有发生交换
 * 解决：定义一个符号量flag，默认有序true；发生交换，置为false，
 * 一趟循环结束后，根据flag的值判断是否有序；有序，退出即可
 * 缺点3：int temp;每次比较的时候都要给temp分配空间，比较完毕后释放空间；
 * 解决：所有的比较都使用都一个temp变量，同一个空间；
 * 将temp变量提取到大循环外
 *
 * @author tianqingzhao
 * @since 2023-05-08 20:19
 */
public class Array9Test {

    public static void main(String[] args) {
        int[] arr = {35, 102, 85, 46, 89, 12, 78};
        System.out.println("排序后：");
        for (int i : arr) {
            System.out.print(i + "\t");
        }

        int temp;

        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;

            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }

        System.out.println("排序后：");
        for (int k : arr) {
            System.out.print(k + "\t");
        }
    }

}
