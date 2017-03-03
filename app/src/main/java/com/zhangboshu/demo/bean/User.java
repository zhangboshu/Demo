package com.zhangboshu.demo.bean;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangBoshu on 2017/3/2.
 */

public class User extends DataSupport {

    private int id;
    private String name;
    private String userId;
    private List<Money> moneys = new ArrayList<>();

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Money> getMoneys() {
        return DataSupport.where("user_id = ?", String.valueOf(id)).find(Money.class);
    }

    public void setMoneys(List<Money> moneys) {
        this.moneys = moneys;
    }
}
