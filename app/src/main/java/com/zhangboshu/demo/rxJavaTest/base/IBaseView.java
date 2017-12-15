package com.zhangboshu.demo.rxJavaTest.base;

/**
 * Created by zhangboshu on 2017/12/15.
 */

public interface IBaseView<T> {

    void showProgress();

    void hideProgress();

    void loadDataSuccess(T data);

    void loadDataError(Throwable e);

}
