package com.zhangboshu.demo.ui.fragmentText.fragment.child;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.zhangboshu.demo.base.BaseFragment;

/**
 * Created by zhangboshu on 2017/12/14.
 */

public class TextFragment1_1 extends BaseFragment{

    public static TextFragment1_1 newInstance() {
        Bundle args = new Bundle();
        TextFragment1_1 fragment = new TextFragment1_1();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {

    }
}
