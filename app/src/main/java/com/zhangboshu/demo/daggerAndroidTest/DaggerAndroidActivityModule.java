package com.zhangboshu.demo.daggerAndroidTest;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZhangBoshu on 2018/1/11.
 */
@Module
public abstract class DaggerAndroidActivityModule {

    //需要注入什么写什么

    @Provides
    @ActivityScope
    static Students provedesStudent(){
        return new Students();
    }
}
