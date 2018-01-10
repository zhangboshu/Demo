package com.zhangboshu.demo.dagger;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZhangBoshu on 2018/1/10.
 */

@Module
public class PotModule {

    @Provides
    Pot provides(@RoseFlower Flower flower){
        return new Pot(flower);
    }
}
