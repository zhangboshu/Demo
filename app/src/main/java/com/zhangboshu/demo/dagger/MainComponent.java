package com.zhangboshu.demo.dagger;

import dagger.Component;

/**
 * Created by ZhangBoshu on 2018/1/9.
 */

@Component(modules = MainModule.class) //该接口包含几个module
public interface MainComponent {
    void inject(DaggerActivity activity);
}
