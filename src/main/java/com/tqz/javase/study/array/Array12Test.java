package com.tqz.javase.study.array;

/**
 * 功能：存储3个班级,每个班级最多4个学生的分数
 * 技能：二维数组
 *
 * <p>
 * int [][]  scoreArr = new int[3][];//0-2  0-3
 * scoreArr[0] = new int[4];
 * scoreArr[1] = new int[3];
 * scoreArr[2] = new int[2];
 * System.out.println(scoreArr.length);//3
 * System.out.println(scoreArr[0].length);//4
 * System.out.println(scoreArr[1].length);//3
 * System.out.println(scoreArr[2].length);//2
 * 总结1：一定要明白二维数组的内存分配结构
 * 总结2：有一维数组，有二维数组，就有三维数组，四维数组.....
 * 一维数组:存储一个班10个学生的分数
 * 二维数组：存储5个班各10个学生的分数
 * 三维数组：存储6个年级个5个班各10个学生的分数
 * 四维数组：存储10个学校6个年级个5个班各10个学生的分数
 * 总结3：其实只要一维数组，没有二维数组，三维数组
 * int  []  scoreArr = new int[10]  定义了一个一维数组，长度是10，每个元素是int类型
 * int  [][]  scoreArr = new int[5][10] 定义了一个一维数组，长度是5，每个元素是一个一维数组
 * 总结4：二维数组的静态初始化
 * 声明+分配空间+赋值
 *
 * @author tianqingzhao
 * @since 2023-05-09 20:01
 */
public class Array12Test {

    public static void main(String[] args) {
        //定义一个二维数组
		/*
		int [][]  scoreArr = new int[3][];//0-2  0-3
		scoreArr[0] = new int[4];
		scoreArr[1] = new int[3];
		scoreArr[2] = new int[2];
		//存储3个班级分别4个学生的分数
		scoreArr[0][0] = 90;
		scoreArr[0][1] = 100;
		scoreArr[0][2] = 90;
		scoreArr[0][3] = 100;

		scoreArr[1][0] = 89;
		scoreArr[1][1] = 89;

		scoreArr[2][0]  = 100;
		*/
        //int [] scoreArr = new int [] {10,20,40,50};
        //int [] [] scoreArr = new int[][]{{90,100,90,100},{89,89,0},{100}};
        int[][] scoreArr = {{90, 100, 90, 100}, {89, 89, 0}, {100}};
        //输出分数
        System.out.println(scoreArr);
        System.out.println(scoreArr[0]);

        System.out.println(scoreArr.length);//3
        System.out.println(scoreArr[0].length);//4
        System.out.println(scoreArr[1].length);//3
        System.out.println(scoreArr[2].length);//2

        //遍历数组的所有元素
        for (int i = 0; i < scoreArr.length; i++) {
            //
            System.out.println("第" + (i + 1) + "个班的学生分数");
            //
            for (int j = 0; j < scoreArr[i].length; j++) {
                System.out.print(scoreArr[i][j] + "\t");
            }
            //
            System.out.println();
        }
    }
}
