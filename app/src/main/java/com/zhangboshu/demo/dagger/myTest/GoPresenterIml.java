package com.zhangboshu.demo.dagger.myTest;

import android.content.Context;

import com.zhangboshu.demo.rxJavaTest.BaseBean;
import com.zhangboshu.demo.rxJavaTest.base.BasePresenterImpl;

import javax.inject.Inject;

/**
 * Created by zhangboshu on 09/01/18.
 */

public class GoPresenterIml extends BasePresenterImpl<GoIView, BaseBean> {


    private final Context context;
    @Inject
    GoModel goModel;

    public GoPresenterIml(GoIView view, Context context) {
        super(view);
        this.context = context;
//        model = new GoModel(context);
        GoComponent build = DaggerGoComponent.builder().build();//调取无参构造器
        build.injectPresenter(this);
    }

    public void getGoModel(String name){
//        model.loadGoData(name, this);
        goModel.loadGoData(name, this);
    }
}
