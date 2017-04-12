package com.zhangboshu.demo.ui;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ZhangBoshu on 2017/3/30.
 */

public class Text implements Parcelable {

    public int id;
    public String name;
//    public Book book;


    public Text(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //从序列化后的对象中创建原始对象
    protected Text(Parcel in) {
        id = in.readInt();
        name = in.readString();
        //另一个序列化对象,所以他反序列化需要传递当先前程上下文类加载器,否则报错
//        book = in.readParcelable(Thread.currentThread().getContextClassLoader());
    }

    //反序列化
    public static final Creator<Text> CREATOR = new Creator<Text>() {
        @Override
        //从序列化后的对象中创建原始对象
        public Text createFromParcel(Parcel in) {
            return new Text(in);
        }

        //创建指定长度的原始对象数组
        @Override
        public Text[] newArray(int size) {
            return new Text[size];
        }
    };

    //内容描述,一般都返回0
    @Override
    public int describeContents() {
        return 0;
    }

    //序列化
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
//        dest.writeParcelable(book, 0);  //实体类
    }
}
