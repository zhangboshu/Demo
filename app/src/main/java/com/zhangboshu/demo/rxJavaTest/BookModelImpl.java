package com.zhangboshu.demo.rxJavaTest;

import android.content.Context;

import com.zhangboshu.demo.rxJavaTest.base.BaseModel;
import com.zhangboshu.demo.rxJavaTest.base.IBasePresenter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by zhangboshu on 2017/12/15.
 */

public class BookModelImpl extends BaseModel {

    private Context context;
    private final ApiService api;

    public BookModelImpl(Context context) {
        this.context = context;
        api = RetrofitFactory.getInstence().API();
    }

    public void loadBookData(String name, final IBasePresenter<BaseBean> presenter) {
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
