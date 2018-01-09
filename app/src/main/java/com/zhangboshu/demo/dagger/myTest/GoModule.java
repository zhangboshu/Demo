package com.zhangboshu.demo.dagger.myTest;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhangboshu on 09/01/18.
 */

@Module
public class GoModule {

    private GoIView goIView;
    private Context context;

    public GoModule(){

    }

    public GoModule(GoIView goIView, Context context){
        this.goIView = goIView;
        this.context = context;
    }

    @Provides
    GoPresenterIml providesGoPresenter(){
        return new GoPresenterIml(goIView, context);
    }

    @Provides
    GoModel providesGoModule(){
        return new GoModel(context);
    }
}
