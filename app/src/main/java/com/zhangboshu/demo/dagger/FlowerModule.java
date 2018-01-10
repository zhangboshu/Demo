package com.zhangboshu.demo.dagger;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZhangBoshu on 2018/1/10.
 */
@Module
public class FlowerModule {

    @Provides
    @RoseFlower
    Flower providesRose(){
        return new Rose();
    }

    @Provides
    @LilyFlower
    Flower providesLily(){
        return new Lily();
    }
}
