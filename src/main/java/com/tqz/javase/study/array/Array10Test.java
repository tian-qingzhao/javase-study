package com.tqz.javase.study.array;

/**
 * 技能：可变参数
 *
 * <p>
 * 缺点：实现3个int的相加如何？
 * 解决：方法的重载
 * <p>
 * 缺点：实现4,5,6,7,8个int的相加如何？
 * 解决：使用数组做形参
 *
 * <p>
 * 缺点：使用数组做形参减少了方法重载的数量，但是实参需要先放入数组中
 * 解决：可变参数
 * <p>
 * 总结1
 * 1.可变参数语法  ...  JDK 1.5增加的内容
 * 2.可变参数的好处：简单 方便 直观  减少方法重载的数量
 * 3.可变参数只能做方法的形参
 * 4.可变参数的实参可以是0个、1个、多个，也可以是一个数组
 * 5.一旦定义了可变参数，就不能定义数组参数了
 * 6.在方法体中，可变参数是当做数组来处理的
 * 7.一个方法的可变参数只能有一个，必须是最后一个参数
 * 总结2：可变参数和数组参数的区别和联系
 * 联系
 * 1.在方法体中，可变参数是当做数组来处理的
 * 2.方法的实参都可以是数组
 * 区别
 * 1.个数不同
 * 一个方法的可变参数只能有一个
 * 一个方法的数组参数可以有多个
 * 2.位置不同
 * 一个方法的可变参数只能是最后一个
 * 一个方法的数组参数位置任意
 * 3.实参不同
 * 数组参数的实参必须是数组
 * 可变参数的实参可以是0个、1个、多个，也可以是一个数组
 *
 * @author tianqingzhao
 * @since 2023-05-09 18:54
 */
public class Array10Test {

    public static void main(String[] args) {
        System.out.println(add(10, 20));
        System.out.println(add(10, 20, 30));
        int[] numArr = {10, 20, 30, 40, 50, 60};
        System.out.println(add(numArr));

        System.out.println(add(10, 20, 30, 40, 50));
        System.out.println(add());
        //System.out.println(add(null)); // 不能为null，否则会报空指针异常
        System.out.println(add(10));
        System.out.println(add(10, 20));
        System.out.println(add(10, 20, 30));
    }

    /*
    public static int add(int num1,int num2){
        return num1+num2;
    }
    public static int add(int num1,int num2,int num3){
        return num1+num2+num3;
    }
    */

    public static int add(int... numArr) {
        int sum = 0;
        for (int num : numArr) {
            sum += num;
        }
        return sum;
    }

	/*
	public static int add(int [] numArr){
		int sum = 0;
		for(int num :numArr){
			sum += num;
		}
		return sum;
	}
	*/
}
