package com.zhangboshu.demo.dagger;

import android.os.Bundle;
import android.util.Log;

import com.zhangboshu.demo.R;
import com.zhangboshu.demo.base.BaseActivity;

import javax.inject.Inject;

public class DaggerActivity extends BaseActivity {

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

    @Override
    public void getNetNow(String netState) {

    }
}
