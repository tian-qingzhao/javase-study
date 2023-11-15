package com.tqz.javase.study.array;

/**
 * 功能：使用数组存储分数，删除指定索引的分数
 * 技能：数组的应用--删除
 *
 * <p>
 * 删除前：{75,  87,  56,  45,  89,  100,  76,  34,  89,  97};
 * 删除后：{75,  87,  56,  45,  100,  76,  34,  89,  97,  0};
 * ------------------ 从100开始 i    i+1
 * scoreArr[i]=scoreArr[i+1]
 * 数组的优点：
 * 1.一个数组可以存储多个元素
 * 2.按照索引查询元素效率高
 * 数组的缺点：
 * 1.按照内容查询元素，效率低下
 * 2.进行删除和添加时候需要大量的移动元素，效率低下；
 * 3.长度固定
 *
 * <p>再次理解数组内存分配的过程。同 {@link Array4Test} 查找原理一样，
 * 引用类型通过参数给其他方法赋值，都会指向堆内存的同一块地址。
 *
 * @author tianqingzhao
 * @since 2023-05-07 20:36
 */
public class Array7Test {

    public static void main(String[] args) {
        //使用数组存储分数
        int[] scoreArr = {75, 87, 56, 45, 89, 100, 76, 34, 89, 97};
        //删除之前输出
        System.out.println("删除前");
        for (int score : scoreArr) {
            System.out.print(score + "\t");
        }
        //3.删除第5个元素
        int index = 4;
        deleteElem(scoreArr, index);
        //deleteElem(scoreArr,index);
        //deleteElem(scoreArr,index);
        //删除之后输出
        System.out.println("删除后");
        for (int score : scoreArr) {
            System.out.print(score + "\t");
        }

    }

    /**
     * 功能：删除数组中指定索引的元素
     * 形参：数组arr  索引index
     */
    public static void deleteElem(int[] arr, int index) {
        //3.1从第index个元素开始，将后一个元素前移一个位置
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        //3.2最后一个元素置为0
        arr[arr.length - 1] = 0;
    }
}
