package com.tqz.javase.study.array;

/**
 * 功能1：使用数组存储分数，获取最高分和最低分
 * 功能2：使用数组存储分数，获取最高分和最低分的索引
 *
 * <p>算法：先假设第一个数是最高分，赋给一个变量max，使用max和数组后续元素进行比较
 * 如果元素大于max，该元素就是max，一直比较到所有的元素结束。
 * 最低分同理。
 *
 * @author tianqingzhao
 * @since 2023-05-07 20:07
 */
public class Array5Test {

    public static void main(String[] args) {
        //1.使用数组存储分数
        int[] scoreArr = {75, 87, 56, 45, 89, 100, 76, 34, 89, 97};

        //2.获取最高分的索引
        int maxIndex = 0;
        for (int i = 1; i < scoreArr.length; i++) {
            if (scoreArr[maxIndex] < scoreArr[i]) {
                maxIndex = i;
            }
        }

        //3.输出最高分及其索引
        System.out.println("最高分：" + scoreArr[maxIndex] + ",该分数的索引是" + maxIndex);

		/*
		//2.获取最高分
		//2.1假设第一个数是最高分
		int max = scoreArr[0];
		int min = scoreArr[0];
		//2.2循环依次比较
		for(int i=1;i<scoreArr.length;i++){
			if(max < scoreArr[i]){
				max = scoreArr[i];
			}
			if(min > scoreArr[i]){
				min = scoreArr[i];
			}

		}
		//3.输出最高分
		System.out.println("最高分："+max);
		System.out.println("最低分："+min);
		*/
    }
}
