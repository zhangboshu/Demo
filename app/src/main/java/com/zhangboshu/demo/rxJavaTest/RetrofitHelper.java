package com.zhangboshu.demo.rxJavaTest;

import android.content.Context;

import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhangboshu on 2017/12/15.
 */

public class RetrofitHelper {

    private static final String BASE_URL = "https://api.douban.com/v2/";
    private static final long TIMEOUT = 30;
    private final Context mContext;
    GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder().create());
    private static RetrofitHelper instance = null;
    private Retrofit mRetrofit = null;

    public static RetrofitHelper getInstance(Context context) {
        if (instance == null) {
            instance = new RetrofitHelper(context);
        }
        return instance;
    }

    private RetrofitHelper(Context Context) {
        mContext = Context;
        init();
    }

    private void init() {
        resetApp();
    }

    private void resetApp() {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)//设置连接超时时间
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)//设置写入超时时间
                .addInterceptor(InterceptorUtil.HeaderInterceptor())//添加其他拦截器
                .addInterceptor(InterceptorUtil.LogInterceptor())//添加日志拦截器
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public ApiService getServer() {
        return mRetrofit.create(ApiService.class);
    }

}
