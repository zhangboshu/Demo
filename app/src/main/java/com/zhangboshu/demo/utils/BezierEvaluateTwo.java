package com.zhangboshu.demo.utils;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

/**
 * Created by ZhangBoshu on 2017/2/28.
 */

public class BezierEvaluateTwo implements TypeEvaluator<PointF> {

    private PointF p1;

    public BezierEvaluateTwo(PointF p1) {
        super();
        this.p1 = p1;
    }

    @Override
    public PointF evaluate(float t, PointF p0, PointF p2) {

        PointF pointF = new PointF();

        pointF.x = (1 - t) * (1 - t) * p0.x + 2 * t * (1 - t) * p1.x + t * t * p2.x;
        pointF.y = (1 - t) * (1 - t) * p0.y + 2 * t * (1 - t) * p1.y + t * t * p2.y;

        return pointF;
    }
}
