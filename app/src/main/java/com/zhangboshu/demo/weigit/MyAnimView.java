package com.zhangboshu.demo.weigit;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.zhangboshu.demo.utils.PointEvaluator;

/**
 * Created by zhangboshu on 2017/6/7.
 */

public class MyAnimView extends View {
    private Paint mPaint;
    private PointF mPoint;
    private PointF start;
    private PointF end;

    public MyAnimView(Context context) {
        super(context);
        init();
    }

    public MyAnimView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyAnimView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
    }

    private void drawCircle(Canvas canvas) {
        Log.i("AnimationActivity", "mPoint.x: " + mPoint.x + "-------mPoint.y" + mPoint.y);
        canvas.drawCircle(mPoint.x, mPoint.y, 50, mPaint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mPoint == null) {
            mPoint = new PointF(50, 50);
            drawCircle(canvas);
        } else {
            drawCircle(canvas);
        }
    }

    public void startAnimation(PointF start, PointF end) {
        this.start = start;
        this.end = end;
        ValueAnimator animator = ValueAnimator.ofObject(new PointEvaluator(), start, end);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mPoint = ((PointF) animation.getAnimatedValue());
                invalidate();
            }
        });
        animator.setDuration(2000);
        animator.start();
    }
}
