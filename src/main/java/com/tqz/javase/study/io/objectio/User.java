package com.tqz.javase.study.io.objectio;

import java.io.Serializable;

/**
 * @author tianqingzhao
 * @since 2023-05-27 11:49
 */
public class User implements Serializable {

    /**
     * 指定一个序列化版本号，属性修改都不会报错。
     * 否则会报 Exception in thread "main" java.io.InvalidClassException: com.tqz.javase.study.io.objectio.User; local
     * class incompatible: stream classdesc serialVersionUID = 9217107204685998921, local class serialVersionUID =
     * 1896896584076422343 异常
     */
    private static final long serialVersionUID = 9217107204685998921L;

    private int id;

    private String name;

    /**
     * 使用 transient 关键字修饰的属性不会参与序列化。
     * static属性也不会参数序列化，但是static属性在jvm里面只会有一个值，所以不能随便使用static。
     */
    private transient int age;

    private double score;

    private Amount amount;

    public User() {
    }

    public User(int id, String name, int age, double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", amount=" + amount +
                '}';
    }
}