package com.tqz.javase.study.array;

/**
 * 功能：存储一个班级4个学生的分数
 * 功能：存储3个班级分别4个学生的分数
 * <p>
 * 思路1：定义一个数组，长度是12，存储12个分数
 * int [] scoreArr = new int[12];
 * 不合理：一个班级12个学生
 * 思路2：定义3个数组，长度都是4，分别存一个班的分数
 * int [] scoreArr = new int[4]
 * int [] scoreArr2 = new int[4]
 * int [] scoreArr3 = new int[4]
 * 不合理：数组太多了
 * 思路3：目标：数组少，能够区分3个班级
 * 定义一个二维数组，一个数组就可以存储3个班分别四个学生的信息
 *
 * @author tianqingzhao
 * @since 2023-05-09 19:47
 */
public class Array11Test {

    public static void main(String[] args) {
        //定义一个二维数组
        int[][] scoreArr = new int[3][4];//0-2  0-3
        //存储3个班级分别4个学生的分数
        scoreArr[0][0] = 90;
        scoreArr[0][1] = 100;
        scoreArr[0][2] = 90;
        scoreArr[0][3] = 100;

        scoreArr[1][0] = 89;
        scoreArr[1][1] = 89;

        scoreArr[2][2] = 100;
        //输出分数
        System.out.println(scoreArr);
        System.out.println(scoreArr[0]);

        System.out.println(scoreArr.length);
        System.out.println(scoreArr[0].length);

        System.out.println(scoreArr[0][0]);//90
        System.out.println(scoreArr[1][0]);//89
        System.out.println(scoreArr[2][0]);//0
        System.out.println(scoreArr[2][2]);//100

        //遍历数组的所有元素
        for (int i = 0; i < scoreArr.length; i++) {
            System.out.println("第" + (i + 1) + "个班的学生分数");

            for (int j = 0; j < scoreArr[i].length; j++) {
                System.out.print(scoreArr[i][j] + "\t");
            }

            System.out.println();
        }
    }
}
