package com.tqz.javase.study.datatypeandoper;

/**
 * 功能：用户登录功能（用户名和密码）
 * 技能：逻辑运算符
 *
 * <p>
 * 逻辑运算符
 * &  &&与
 * |   || 或
 * ！ 非
 *
 * <p>
 * username == "bjsxt" && password =="bjsxt"
 * 1.  关系运算1  && 关系运算2
 * 2.      true    &&     false
 * 3                false
 *
 * <p>
 * 逻辑运算的操作数和运算结果都是布尔值
 * 关系运算的操作数不是布尔值，运算结果是布尔值
 *
 * <p>
 * & | 都是双目运算符
 * ! 是单目运算符
 *
 * @author tianqingzhao
 * @since 2023-05-17 18:34
 */
public class OperationTest7 {

    public static void main(String[] args) {
        //给定用户名和密码
        String username = "bjsxt1";
        String password = "bjsxt2";
        //判断登录是否成功
        if (username == "bjsxt" && password == "bjsxt") {//用户名是bjsxt 并且与和 密码是bjsxt
            System.out.println("登录成功");
        }
        if (username != "bjsxt" || password != "bjsxt") {//用户名不是bjsxt 或者  密码不是bjsxt
            System.out.println("登录失败");
        }
        // 不是登录成功（用户名是bjsxt 并且与和 密码是bjsxt），就是失败
        if (!(username == "bjsxt" && password == "bjsxt")) {
            System.out.println("登录失败");//false == false ---> true  1==1
        }
    }
}
