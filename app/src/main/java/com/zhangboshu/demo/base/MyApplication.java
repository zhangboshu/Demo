package com.zhangboshu.demo.base;

import android.app.Application;

import org.litepal.LitePal;

/**
 * Created by ZhangBoshu on 2017/3/2.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(getApplicationContext()); //初始化数据库框架
    }
}
