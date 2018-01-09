package com.zhangboshu.demo.dagger;

import javax.inject.Inject;

/**
 * Created by ZhangBoshu on 2018/1/9.
 */

public class Shoe {

    @Inject  //不创建module,直接在构造器上声明注入
    public Shoe(){

    }

    @Override
    public String toString() {
        return "鞋子";
    }
}
