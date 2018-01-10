package com.zhangboshu.demo.dagger;

/**
 * Created by ZhangBoshu on 2018/1/10.
 */

public class Pot {

    private final Flower flower;

    //pot 盆, 需要依赖flower
    public Pot(Flower flower){
        this.flower = flower;
    }

    public String show(){
        return flower.whisper();
    }
}
