package com.zhangboshu.demo.rxJavaTest.base;

/**
 * Created by zhangboshu on 2017/12/15.
 */

public class BasePresenterImpl<T extends IBaseView, V> implements IBasePresenter<V> {

    public IBaseView iView;

    public BasePresenterImpl(T view){
        this.iView = view;
    }

    @Override
    public void beforeRequest() {
        iView.showProgress();
    }


    @Override
    public void requestError(Throwable e) {
        iView.loadDataError(e);
    }

    @Override
    public void requestComplete() {
        iView.hideProgress();
    }

    @Override
    public void requestSuccess(V data) {
        iView.loadDataSuccess(data);
    }
}
