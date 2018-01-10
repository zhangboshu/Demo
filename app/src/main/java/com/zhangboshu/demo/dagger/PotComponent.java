package com.zhangboshu.demo.dagger;

import dagger.Component;

/**
 * Created by ZhangBoshu on 2018/1/10.
 */

@Component(modules = PotModule.class, dependencies = FlowerComponent.class) //依赖另一个componet, 获得其中的方法
public interface PotComponent {
    Pot getPot();
}
