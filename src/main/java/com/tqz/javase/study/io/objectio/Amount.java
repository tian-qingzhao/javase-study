package com.tqz.javase.study.io.objectio;

import java.io.Serializable;

/**
 * @author tianqingzhao
 * @since 2023-05-27 11:52
 */
public class Amount implements Serializable {

    private static final long serialVersionUID = 8364638853675989438L;

    private int id;

    private double money;

    public Amount() {
    }

    public Amount(int id, double money) {
        this.id = id;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }
}
