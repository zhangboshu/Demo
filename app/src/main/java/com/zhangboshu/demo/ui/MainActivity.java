package com.zhangboshu.demo.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zhangboshu.demo.R;
import com.zhangboshu.demo.base.BaseActivity;

import java.util.Random;

public class MainActivity extends BaseActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private ViewGroup anim_mask_layout;
    private ImageView buyImg;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 一个整型数组，用来存储按钮的在屏幕的X、Y坐标
                int[] start_location = new int[2];
                // 这是获取购买按钮的在屏幕的X、Y坐标（这也是动画开始的坐标）
                v.getLocationInWindow(start_location);
                buyImg = new ImageView(MainActivity.this);
                // 设置buyImg的图片
                buyImg.setImageBitmap(getAddDrawBitMap());
                // 开始执行动画
                setAnim(buyImg, start_location);
            }
        });
    }

    private void setAnim(final View v, int[] startLocation) {
        anim_mask_layout = null;
        anim_mask_layout = createAnimLayout(this);
        // 把动画小球添加到动画层
        anim_mask_layout.addView(v);
        final View view = addViewToAnimLayout(v, startLocation);
        // 这是用来存储动画结束位置的X、Y坐标
        int[] end_location = new int[2];
        // rl_gouwuche是小球运动的终点 一般是购物车图标
        button8.getLocationInWindow(end_location);

        // 计算位移
        int endX = end_location[0] - startLocation[0];// 动画位移的X坐标
        int endY = end_location[1] - startLocation[1];// 动画位移的y坐标
//        TranslateAnimation translateAnimationX = new TranslateAnimation(0, endX, 0, 0);
//        translateAnimationX.setInterpolator(new LinearInterpolator());
//        translateAnimationX.setRepeatCount(0);// 动画重复执行的次数
//        translateAnimationX.setFillAfter(true);
//
//        TranslateAnimation translateAnimationY = new TranslateAnimation(0, 0, 0, endY);
//        translateAnimationY.setInterpolator(new AccelerateInterpolator());
//        translateAnimationY.setRepeatCount(0);// 动画重复执行的次数
//        translateAnimationX.setFillAfter(true);
//
//
//
//        AnimationSet set = new AnimationSet(false);
//        set.setFillAfter(false);
//        set.addAnimation(translateAnimationY);
//        set.addAnimation(translateAnimationX);
//        set.setDuration(800);// 动画的执行时间

        ObjectAnimator translationX = new ObjectAnimator().ofFloat(view, "translationX", endX);
        ObjectAnimator translationY = new ObjectAnimator().ofFloat(view, "translationY", endY);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(translationX).with(translationY);
        animatorSet.setDuration(1000);
        animatorSet.start();

//        view.startAnimation(set);
        // 动画监听事件
//        set.setAnimationListener(new Animation.AnimationListener() {
//            // 动画的开始
//            @Override
//            public void onAnimationStart(Animation animation) {
//                v.setVisibility(View.VISIBLE);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//                // TODO Auto-generated method stub
//            }
//
//            // 动画的结束
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                v.setVisibility(View.GONE);
//            }
//        });
    }

    private ViewGroup createAnimLayout(Context context) {
        ViewGroup rootView = (ViewGroup) ((Activity) context).getWindow().getDecorView();
        LinearLayout animLayout = new LinearLayout(context);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        animLayout.setLayoutParams(lp);
        animLayout.setId(R.id.animLayout);
        animLayout.setBackgroundResource(android.R.color.transparent);
        rootView.addView(animLayout);
        return animLayout;
    }

    private View addViewToAnimLayout(final View view, int[] location) {
        int x = location[0];
        int y = location[1];
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = x;
        lp.topMargin = y;
        view.setLayoutParams(lp);
        return view;
    }

    /**
     * 运动的控件
     *
     * @return
     */
    public Bitmap getAddDrawBitMap() {
        ImageView text = new ImageView(this);
        // 运动的控件，样式可以自定义
        text.setBackgroundResource(R.mipmap.ic_launcher);
        return convertViewToBitmap(text);
    }

    public Bitmap convertViewToBitmap(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        return bitmap;
    }
}
