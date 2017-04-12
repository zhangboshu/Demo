package com.zhangboshu.demo.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zhangboshu.demo.R;
import com.zhangboshu.demo.base.BaseActivity;
import com.zhangboshu.demo.utils.BezierEvalutor;
import com.zhangboshu.demo.utils.DisplayUtil;

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
    private int mWidth;
    private int mHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    //实时监听网络变化
    @Override
    public void getNetNow(String netState) {

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

        mWidth = DisplayUtil.getMobileWidth(this);
        mHeight = DisplayUtil.getMobileHeight(this);


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

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SQLiteActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setAnim(final View v, int[] startLocation) {
        anim_mask_layout = null;
        anim_mask_layout = createAnimLayout(this);
        // 把动画小球添加到动画层
        anim_mask_layout.addView(v);
        // 这是用来存储动画结束位置的X、Y坐标
        int[] end_location = new int[2];
        // rl_gouwuche是小球运动的终点 一般是购物车图标
        button8.getLocationInWindow(end_location);

        PointF pointF1 = new PointF(end_location[0], startLocation[1]);
        PointF pointF2 = new PointF(mWidth / 2, end_location[1]);
        //贝塞尔曲线的起点
        PointF pointF0 = new PointF(startLocation[0], startLocation[1]);
        //贝塞尔曲线的终点
        PointF pointF3 = new PointF(end_location[0], end_location[1]);
        BezierEvalutor bezierEvalutor = new BezierEvalutor(pointF1, pointF2);
//        BezierEvaluateTwo bezierEvaluateTwo = new BezierEvaluateTwo(pointF1);
        final ValueAnimator valueAnimator = ValueAnimator.ofObject(bezierEvalutor, pointF0, pointF3);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF pointF = (PointF) valueAnimator.getAnimatedValue();
                v.setX(pointF.x);
                v.setY(pointF.y);
            }
        });

        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                v.setVisibility(View.GONE);
                anim_mask_layout.removeView(v);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                v.setVisibility(View.VISIBLE);
            }
        });

        valueAnimator.setTarget(v);
        valueAnimator.setDuration(1000);
        valueAnimator.start();
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
