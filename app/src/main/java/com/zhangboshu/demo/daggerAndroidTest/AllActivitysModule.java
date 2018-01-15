package com.zhangboshu.demo.daggerAndroidTest;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by ZhangBoshu on 2018/1/11.
 * 将所有的activity的component都放在这里,一起提供出去
 */
@Module(subcomponents = {BaseActivityComponent.class}) //关联其他component
public abstract class AllActivitysModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = DaggerAndroidActivityModule.class) //自动生成activityComponent, 只能返回android组件
    abstract DaggerAndroidActivity contributesDaggerAndroidActivityInjector();
}
