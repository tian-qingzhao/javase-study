package com.tqz.javase.study.array;

/**
 * 增强for-数组引用赋值-数组常见异常。
 *
 * <p>增强for：
 * jdk1.5引入的，优点是使用简单，缺点是不能进行索引相关的操作。功能弱，并没有增强。
 *
 * <p>数组的引用赋值：
 * scoreArr声明并初始化完之后会在栈内存的main方法里面开辟一块空间，
 * 并在堆内存里面开辟一块连续的空间，用来存储数组的值，并把栈内存的scoreArr指向堆内存的每个元素。
 * double[] scoreArr2 = scoreArr;
 * 会在栈内存main方法区域再次定义一个变量 scoreArr2 ，
 * 此时 scoreArr2 也会指向堆内存 scoreArr 在堆内存的地址。
 * 由于指向的是同一个内存地址，所以使用 scoreArr[0] = 100;  scoreArr2[4] = 100; 修改两个数组的值，
 * 实际 scoreArr[4] 的元素会变化，scoreArr2[0] 的元素也会变化。
 *
 * <p>数组的异常：
 *
 * @author tianqingzhao
 * @since 2023-05-07 10:26
 */
public class Array2Test {

    public static void main(String[] args) {
        // 静态初始化
        double[] scoreArr = new double[]{34.6, 68.5, 98.2, 63.2, 59};

        // 普通for循环每个提5分
        /*for (int i = 0; i < scoreArr.length; i++) {
            scoreArr[i] = scoreArr[i] + 5;
        }*/
        // 增强for循环每个提5分。赋值给一个新的变量score，score变量的值和数组元素的值相同，
        // 每次 +5 之后修改的是新的变量的值，和数组原来的值无关，所以增强for不能修改值。
        /*for (double score : scoreArr) {
            score = score + 5;
        }*/

        // 引用类型复制，由于 scoreArr 和 scoreArr2 指向的是堆内存的同一块地址，
        // 所以修改其中一个数组，另外一个数组也会跟着变化
        double[] scoreArr2 = scoreArr;
        scoreArr[0] = 100;
        scoreArr2[4] = 100;

        for (double score : scoreArr) {
            System.out.println(score);
        }

        for (double score : scoreArr2) {
            System.out.println(score);
        }

        // 数组的异常
        // 索引的最大值为数组的长度-1
        System.out.println(scoreArr[5]);
        // 索引必须从0开始
        System.out.println(scoreArr[-1]);


    }
}
