package com.zhangboshu.demo.dagger;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZhangBoshu on 2018/1/9.
 */

@Module //告诉dagger这是module类
public class MainModule {

    @Provides //提供依赖对象
    public Cloth getCloth(){
        Cloth cloth = new Cloth();
        cloth.setColor("红色");
        return cloth;
    }

    @Provides
    public Clothes getClothes(Cloth cloth){
        return new Clothes(cloth);
    }
}
