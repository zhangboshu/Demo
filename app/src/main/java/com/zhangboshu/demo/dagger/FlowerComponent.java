package com.zhangboshu.demo.dagger;

import dagger.Component;

/**
 * Created by ZhangBoshu on 2018/1/10.
 */
@Component(modules = FlowerModule.class)
public interface FlowerComponent {
    @RoseFlower
    Flower getRoseFlower();

    @LilyFlower
    Flower getLilyFlower();
}
