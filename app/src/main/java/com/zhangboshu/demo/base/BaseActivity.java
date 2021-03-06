package com.zhangboshu.demo.base;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zhangboshu.demo.utils.NetWorkStateReceiver;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseActivity extends AppCompatActivity implements NetWorkStateReceiver.NetStateInterface {

    private NetWorkStateReceiver receiver;
    private String net;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        receiver = new NetWorkStateReceiver();
        registerReceiver(receiver, filter);

        receiver.getNetState(this);
    }

    //rxjava请求封装
    public <T> ObservableTransformer<T, T> setThread() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    public String getNet() {
        return net;
    }

    public abstract void getNetNow(String netState);

    @Override
    public void getNetwork(String netState) {
        this.net = netState;
        getNetNow(netState);
    }
}
