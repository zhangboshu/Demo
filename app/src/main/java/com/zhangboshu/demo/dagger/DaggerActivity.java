package com.zhangboshu.demo.dagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zhangboshu.demo.R;

import javax.inject.Inject;

public class DaggerActivity extends AppCompatActivity {

    private static final String TAG = "DaggerActivity";

    @Inject
    Cloth cloth;

    @Inject
    Shoe shoe;

    @Inject
    Clothes clothes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);

        MainComponent build = DaggerMainComponent.builder().build();
        build.inject(this);
        Log.d(TAG, "cloth: " + cloth + "  shoe: " + shoe + "Clothes" + clothes);

    }
}