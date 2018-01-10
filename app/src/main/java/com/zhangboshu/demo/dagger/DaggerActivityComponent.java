package com.zhangboshu.demo.dagger;

import dagger.Component;

/**
 * Created by ZhangBoshu on 2018/1/10.
 */

@Component(dependencies = PotComponent.class)
public interface DaggerActivityComponent {
    void inject(DaggerActivity activity);
}
