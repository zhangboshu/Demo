package com.zhangboshu.demo.rxJava;

import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by zhangboshu on 2017/12/25.
 */

public class RxJavaDemo {

    private Observable<String> observable4;
    private static final String TAG = "RxJavaDemo";

    //观察着
    Observer<String> observer = new Observer<String>() {
        @Override
        public void onSubscribe(Disposable d) {
            Log.i(TAG, "onSubscribe: " + d);
        }

        @Override
        public void onNext(String s) {
            Log.i(TAG, "onNext: " + s);
        }

        @Override
        public void onError(Throwable e) {
            Log.i(TAG, "onError: " + e);
        }

        @Override
        public void onComplete() {
            Log.i(TAG, "onComplete: ");
        }
    };

    //观察着, 基本等同于Observer
    Subscriber<String> subscriber = new Subscriber<String>() {
        @Override
        public void onSubscribe(Subscription s) {

        }

        @Override
        public void onNext(String s) {

        }

        @Override
        public void onError(Throwable t) {

        }

        @Override
        public void onComplete() {

        }
    };

    //被观察着, create()方法是 RxJava 最基本的创造事件序列的方法
    Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
        @Override
        public void subscribe(ObservableEmitter<String> e) throws Exception {
            e.onNext("hello");
            e.onNext("Hi");
            e.onNext("wtf");
            e.onComplete();
        }
    });

    //just(T...): 将传入的参数依次发送出来。
    Observable<String> observable2 = Observable.just("hello", "Hi", "wtf");
    // 将会依次调用：
    // onNext("Hello");
    // onNext("Hi");
    // onNext("wtf");
    // onCompleted();

    //from(T[])
    //上面 just(T...) 的例子和 from(T[]) 的例子，都和之前的 create(OnSubscribe) 的例子是等价的。
    String[] words = {"hello", "Hi", "wtf"};
    Observable<String> observable3 = Observable.fromArray(words);

    private void init() {
        observable4 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("hello");
                e.onNext("Hi");
                e.onNext("wtf");
                e.onComplete();
            }
        });
        observable4.subscribe(observer);
    }


}
