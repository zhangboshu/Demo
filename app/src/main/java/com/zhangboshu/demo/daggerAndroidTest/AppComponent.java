package com.zhangboshu.demo.daggerAndroidTest;

import com.zhangboshu.demo.base.MyApplication;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by ZhangBoshu on 2018/1/11.
 * 为了能在myApplication中注入相关module
 */

@Component(modules = {AndroidInjectionModule.class, AndroidSupportInjectionModule.class, AllActivitysModule.class})
public interface AppComponent {
    void inject(MyApplication application);
}
