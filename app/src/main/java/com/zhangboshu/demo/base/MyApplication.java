package com.zhangboshu.demo.base;

import android.app.Activity;
import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.zhangboshu.demo.bean.User;
import com.zhangboshu.demo.daggerAndroidTest.DaggerAppComponent;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by ZhangBoshu on 2017/3/2.
 */

public class MyApplication extends Application implements HasActivityInjector{

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    public static User user;

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent.create().inject(this);

        LitePal.initialize(getApplicationContext()); //初始化数据库框架
        Connector.getDatabase();

        Logger.addLogAdapter(new AndroidLogAdapter());

        List<User> users = DataSupport.where("userid = ?", "123").find(User.class);
        if (users.isEmpty()){
            user = new User();
            user.setUserId("123");
            user.setName("MJ");
            user.save();
        }else{
            user = users.get(0);
        }
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
