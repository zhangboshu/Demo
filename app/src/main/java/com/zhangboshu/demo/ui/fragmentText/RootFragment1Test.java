package com.zhangboshu.demo.ui.fragmentText;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.zhangboshu.demo.R;
import com.zhangboshu.demo.base.BaseFragment;
import com.zhangboshu.demo.ui.fragmentText.fragment.TextFragment1;
import com.zhangboshu.demo.ui.fragmentText.fragment.child.TextFragment1_1;

/**
 * Created by zhangboshu on 2017/12/14.
 */

public class RootFragment1Test extends BaseFragment{
    public static TextFragment1 newInstance() {
        Bundle args = new Bundle();
        TextFragment1 fragment = new TextFragment1();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_text_1;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        if (findChildFragment(TextFragment1_1.class) == null) {
            loadRootFragment(R.id.fl_container, TextFragment1_1.newInstance());
        }
    }
}
