package com.zhangboshu.demo.dagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zhangboshu.demo.R;

import javax.inject.Inject;

public class DaggerActivity extends AppCompatActivity {

    private static final String TAG = "DaggerActivity";

    @Inject
    Pot pot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);

        DaggerDaggerActivityComponent.builder().
                potComponent(DaggerPotComponent.builder()
                        .flowerComponent(DaggerFlowerComponent.create()).build())
                .build().inject(this);

        String show = pot.show();
        Log.d(TAG, "potShow: " + show);

    }
}
