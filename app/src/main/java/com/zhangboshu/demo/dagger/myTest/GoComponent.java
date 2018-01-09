package com.zhangboshu.demo.dagger.myTest;

import dagger.Component;

/**
 * Created by zhangboshu on 09/01/18.
 */

@Component(modules = GoModule.class)
public interface GoComponent {
    void inject(GoDaggerActivity activity);
    void injectPresenter(GoPresenterIml goPresenterIml);
}
