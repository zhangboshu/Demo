package com.zhangboshu.demo.ui;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zhangboshu.demo.R;
import com.zhangboshu.demo.utils.PointEvaluator;
import com.zhangboshu.demo.weigit.MyAnimView;

public class AnimationActivity extends AppCompatActivity {

    private ImageView myImg;
    private Button myBtn;

    private static final String TAG = "AnimationActivity";
    private MyAnimView goImg;
    private Button yidong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

    }

    //当activity完全绘制完成,肉眼可见的情况下回调此方法.一般用作测量控件时候使用
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        initViews();
    }

    private void initViews() {
        myImg = (ImageView) findViewById(R.id.imageView);
        myBtn = (Button) findViewById(R.id.button);
        goImg = (MyAnimView) findViewById(R.id.point);
        yidong = (Button) findViewById(R.id.yidong);

        final int startLocation[] = new int[2];
        goImg.getLocationInWindow(startLocation);
        Log.i(TAG, "startLocation: " + startLocation[0] + "-----" + startLocation[1]);

        final int location[] = new int[2];
        //父窗口坐标
        myImg.getLocationInWindow(location);
        Log.i(TAG, "endLocation: " + location[0] + "-----" + location[1]);

        final PointF startPoint = new PointF(startLocation[0], startLocation[1]);
        final PointF endPoint = new PointF(location[0], location[1]);

        yidong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goImg.startAnimation(startPoint, endPoint);
            }
        });
    }

    private void goAmin() {

        int startLocation[] = new int[2];
        goImg.getLocationInWindow(startLocation);
        Log.i(TAG, "startLocation: " + startLocation[0] + "-----" + startLocation[1]);

        final int location[] = new int[2];
        //父窗口坐标
        myImg.getLocationInWindow(location);
        Log.i(TAG, "endLocation: " + location[0] + "-----" + location[1]);

        //整个屏幕坐标
//        int screenLoc[] = new int[2];
//        myImg.getLocationOnScreen(screenLoc);
//        Log.i(TAG, "locationOnScreen: " + screenLoc[0] + "-----" + screenLoc[1]);

        PointF startPoint = new PointF(startLocation[0], startLocation[1]);
        PointF endPoint = new PointF(location[0], location[1]);

        final ValueAnimator valueAnimator = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF point = (PointF) animation.getAnimatedValue();
                goImg.setX(point.x);
                goImg.setY(point.y);
            }
        });

        valueAnimator.setDuration(2000);
        valueAnimator.start();
    }

    /**
     * 开启post获取控件的实际宽高,设置锚点,实现缩放往一边靠
     */
    private void getWidthAndHeight() {
        myImg.post(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "initViews: " + myImg.getWidth());
                Log.i(TAG, "initViews: " + myImg.getX());
                Log.i(TAG, "initViews: " + myImg.getMeasuredWidth());

                //setPivotX 和 setPivotY 是相对于view自身的左上角为原点
                myImg.setPivotX(myImg.getWidth());
                myImg.setPivotY(myImg.getHeight());

                myBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myImg.animate().scaleX(0.5f).scaleY(0.5f).setDuration(2000);
                    }
                });
            }
        });
    }
}
