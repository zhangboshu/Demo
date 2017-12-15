package com.zhangboshu.demo.rxJavaTest;

import android.content.Context;

import com.zhangboshu.demo.rxJavaTest.base.BasePresenterImpl;

/**
 * Created by zhangboshu on 2017/12/15.
 */

public class BookPresenterImpl extends BasePresenterImpl<BookView, BaseBean> {

    private Context context;
    private final BookModelImpl bookModel;

    public BookPresenterImpl(BookView view, Context context) {
        super(view);
        this.context = context;
        bookModel = new BookModelImpl(context);
    }

    public void getBookInfo(String name){
        bookModel.loadBookData(name, this);
    }

}
