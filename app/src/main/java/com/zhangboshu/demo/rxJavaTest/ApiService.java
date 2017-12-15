package com.zhangboshu.demo.rxJavaTest;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zhangboshu on 2017/12/15.
 */

public interface ApiService {

    @GET("book/search")
    Observable<BaseBean> getData(@Query("q") String name,
                                 @Query("tag") String tag, @Query("start") int start,
                                 @Query("count") int count);
}
