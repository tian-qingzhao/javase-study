package com.tqz.javase.study.array;

import java.util.Arrays;

/**
 * {@link java.util.Arrays} 工具类的使用。
 * Arrays.toString(scoreArr)
 * Arrays.sort(scoreArr);
 * Arrays.binarySearch(scoreArr, 89)
 * Arrays.fill(scoreArr,3, 8, 10);
 * Arrays.copyOf(scoreArr, 5);
 *
 * @author tianqingzhao
 * @since 2023-05-08 21:33
 */
public class ArraysTest {

    public static void main(String[] args) {
        //定义一个数组
        int[] scoreArr = {75, 87, 56, 45, 89, 100, 76, 34, 89, 97};

        //遍历数组
        System.out.println(Arrays.toString(scoreArr));

        //数组排序
        Arrays.sort(scoreArr);
        System.out.println(Arrays.toString(scoreArr));

        //查询数据
        int index = Arrays.binarySearch(scoreArr, 89);
        System.out.println(index);

        //数组的填充
        // Arrays.fill(scoreArr,10);
        Arrays.fill(scoreArr, 3, 8, 10);
        System.out.println(Arrays.toString(scoreArr));

        //数组复制
		 /*
		int [] scoreArr2 = new int[10];
		for(int i=0;i<scoreArr2.length;i++){
			scoreArr2[i] = scoreArr[i];
		}*/
        int[] scoreArr2 = Arrays.copyOf(scoreArr, scoreArr.length);
        //int [] scoreArr2 = Arrays.copyOf(scoreArr,20);
        //int [] scoreArr2 = Arrays.copyOf(scoreArr,5);

        System.out.println(Arrays.toString(scoreArr2));

        // 数组比较
        boolean flag = Arrays.equals(scoreArr, scoreArr2);
        System.out.println(flag);
    }
}
