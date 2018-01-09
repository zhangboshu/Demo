package com.zhangboshu.demo.dagger.myTest;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.zhangboshu.demo.R;
import com.zhangboshu.demo.base.BaseActivity;
import com.zhangboshu.demo.rxJavaTest.BaseBean;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoDaggerActivity extends BaseActivity implements GoIView {

    private static final String TAG = "GoDaggerActivity";

    @BindView(R.id.showTv)
    TextView showTv;
    @BindView(R.id.showBtn)
    Button showBtn;

    @Inject
    GoPresenterIml goPresenterIml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_dagger);
        ButterKnife.bind(this);

        initData();
    }

    @OnClick(R.id.showBtn)
    public void onViewClicked() {
        goPresenterIml.getGoModel("金瓶梅");
    }

    private void initData() {
        GoComponent build = DaggerGoComponent.builder().goModule(new GoModule(this, this)).build();
        build.inject(this);
    }

    @Override
    public void getNetNow(String netState) {

    }

    @Override
    public void showProgress() {
        Log.d(TAG, "showProgress: ");
    }

    @Override
    public void hideProgress() {
        Log.d(TAG, "hideProgress: ");
    }

    @Override
    public void loadDataSuccess(BaseBean data) {
        showTv.setText(data.toString());
    }

    @Override
    public void loadDataError(Throwable e) {
        showTv.setText(e.toString());
    }


}
