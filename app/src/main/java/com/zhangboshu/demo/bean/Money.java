package com.zhangboshu.demo.bean;

import org.litepal.crud.DataSupport;

/**
 * Created by ZhangBoshu on 2017/3/2.
 */

public class Money extends DataSupport {
    private int id;
    private User user;
    private String name;
    private float num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getNum() {
        return num;
    }

    public void setNum(float num) {
        this.num = num;
    }
}
