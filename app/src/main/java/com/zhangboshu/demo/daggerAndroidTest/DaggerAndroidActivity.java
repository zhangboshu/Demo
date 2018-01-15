package com.zhangboshu.demo.daggerAndroidTest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.zhangboshu.demo.R;
import com.zhangboshu.demo.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

public class DaggerAndroidActivity extends BaseActivity {

    @Inject
    Students students;
    @BindView(R.id.showTv)
    TextView showTv;
    @BindView(R.id.showBtn)
    Button showBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_dagger);
        ButterKnife.bind(this);
    }

    @Override
    public void getNetNow(String netState) {

    }

    @OnClick(R.id.showBtn)
    public void onViewClicked() {
        showTv.setText("学生名字: " + students.getName());
    }
}
