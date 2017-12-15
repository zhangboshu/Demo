package com.zhangboshu.demo.rxJavaTest.base;

/**
 * Created by zhangboshu on 2017/12/15.
 */

public interface IBasePresenter<T> {

    void beforeRequest();

    void requestError(Throwable e);

    void requestComplete();

    void requestSuccess(T data);
}
