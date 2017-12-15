package com.zhangboshu.demo.rxJavaTest;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.zhangboshu.demo.R;
import com.zhangboshu.demo.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RxTestActivity extends BaseActivity implements BookView {

    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.button15)
    Button button15;

    private static final String TAG = "RxTestActivity";

    private BookPresenterImpl bookPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_test);
        ButterKnife.bind(this);

        initData();
    }

    @Override
    public void getNetNow(String netState) {

    }

    private void initData() {

        bookPresenter = new BookPresenterImpl(this, this);


    }

    @OnClick(R.id.button15)
    public void onViewClicked() {
        bookPresenter.getBookInfo("金瓶梅");
    }

    @Override
    public void showProgress() {
        Log.i(TAG, "showProgress: ");
    }

    @Override
    public void hideProgress() {
        Log.i(TAG, "hideProgress: ");
    }

    @Override
    public void loadDataSuccess(BaseBean data) {
        textView2.setText(data.getBooks().get(0).getSummary());
    }

    @Override
    public void loadDataError(Throwable e) {
        textView2.setText(e.toString());
    }
}