package com.zhangboshu.demo.dagger.myTest;

import android.content.Context;

import com.zhangboshu.demo.rxJavaTest.ApiService;
import com.zhangboshu.demo.rxJavaTest.BaseBean;
import com.zhangboshu.demo.rxJavaTest.RetrofitFactory;
import com.zhangboshu.demo.rxJavaTest.base.BaseModel;
import com.zhangboshu.demo.rxJavaTest.base.IBasePresenter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by zhangboshu on 09/01/18.
 */

public class GoModel extends BaseModel {
    private final ApiService api;

    public GoModel() {
        api = RetrofitFactory.getInstence().API();
    }

    public void loadGoData(String name, final IBasePresenter<BaseBean> presenter) {
        api.getData(name, null, 0, 1)
                .compose(this.<BaseBean>setThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        presenter.beforeRequest();
                    }

                    @Override
                    public void onNext(BaseBean baseBean) {
                        presenter.requestSuccess(baseBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        presenter.requestError(e);
                    }

                    @Override
                    public void onComplete() {
                        presenter.requestComplete();
                    }
                });
    }
}
