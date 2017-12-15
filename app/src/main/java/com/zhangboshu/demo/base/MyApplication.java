package com.zhangboshu.demo.base;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.zhangboshu.demo.bean.User;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

/**
 * Created by ZhangBoshu on 2017/3/2.
 */

public class MyApplication extends Application {

    public static User user;

    @Override
    public void onCreate() {
        super.onCreate();
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
}
