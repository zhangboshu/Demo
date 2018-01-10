package com.zhangboshu.demo.dagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by ZhangBoshu on 2018/1/10.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface LilyFlower {
}
