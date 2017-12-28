package com.zhangboshu.demo.rxJava;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zhangboshu.demo.R;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);

        init();
    }

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
//        observable4.subscribe(observer);

        Observable.create(new ObservableOnSubscribe<Drawable>() {
            @Override
            public void subscribe(ObservableEmitter<Drawable> e) throws Exception {

            }
        })
                .subscribeOn(Schedulers.io())// 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread())// 指定 Subscriber 的回调发生在主线程
                .subscribe(new Observer<Drawable>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Drawable drawable) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "onNext: " + s);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };

        Money[] monies = new Money[]{new Money()};

        Observable.fromArray(monies).map(new Function<Money, String>() {
            @Override
            public String apply(Money money) throws Exception {
                return money.getName();
            }
        }).subscribe(observer);


        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1); //发送
            }
        }).map(new Function<Integer, String>() {  //转换, 将integer转换成String
            @Override
            public String apply(Integer integer) throws Exception {
                return "This is result" + integer;
            }
        }).subscribe(new Consumer<String>() { //无参subscribe全部接收上面传来的数据, 1参只接受onNext,以此类推
            @Override
            public void accept(String s) throws Exception {
                Log.i(TAG, "accept: " + s); //接收
            }
        });

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1); //发送3个数字
                e.onNext(2);
                e.onNext(3);
            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() { //将数字转换成Observable序列,
            // 如果将flatMap替换为concatMap,返回结果将成为有序排列
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    list.add("I am value" + integer);
                }
                return Observable.fromIterable(list).delay(10, TimeUnit.MILLISECONDS); //返回List, 延迟10毫秒
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.i(TAG, "accept: " + s);
            }
        });


    }


}
