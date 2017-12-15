package com.zhangboshu.demo.rxJavaTest;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.util.Log;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by zhangboshu on 2017/12/15.
 */

public abstract class BaseObserver implements Observer<BaseBean> {

    protected Context context;

    public BaseObserver(Context context) {
        this.context = context;
    }

    public BaseObserver() {

    }

    @Override
    public void onSubscribe(Disposable d) {
        onRequestStart();
    }

    @Override
    public void onNext(BaseBean tBaseBean) {
//        if (tBaseBean.getResult() == 200) {
//            try {
//                onSuccees(tBaseBean);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
//            try {
//                onCodeError(tBaseBean);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        try {
            onSuccess(tBaseBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onError(Throwable e) {
        //        Log.w(TAG, "onError: ", );这里可以打印错误信息
        onRequestEnd();
        try {
            if (e instanceof ConnectException
                    || e instanceof TimeoutException
                    || e instanceof NetworkErrorException
                    || e instanceof UnknownHostException) {
                onFailure(e, true);
            } else {
                onFailure(e, false);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void onComplete() {
        onRequestEnd();
    }

    /**
     * 返回成功
     *
     * @param t
     * @throws Exception
     */
    protected abstract void onSuccess(BaseBean t) throws Exception;

    /**
     * 返回成功了,但是code错误
     *
     * @param t
     * @throws Exception
     */
    protected void onCodeError(BaseBean t) throws Exception {

    }

    /**
     * 返回失败
     *
     * @param e
     * @param isNetWorkError 是否是网络错误
     * @throws Exception
     */
    protected abstract void onFailure(Throwable e, boolean isNetWorkError) throws Exception;

    protected void onRequestStart() {
        showProgressDialog();
    }

    protected void onRequestEnd() {
        closeProgressDialog();
    }

    public void showProgressDialog() {
        Log.i("aaa", "showProgressDialog: ");
    }

    public void closeProgressDialog() {
        Log.i("aaa", "colseProgressDialog: ");
    }
}
