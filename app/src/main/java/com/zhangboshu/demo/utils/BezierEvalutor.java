package com.zhangboshu.demo.utils;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

/**
 * Created by ZhangBoshu on 2017/2/27.
 */

public class BezierEvalutor implements TypeEvaluator<PointF> {

    PointF p1;
    PointF p2;

    public BezierEvalutor(PointF p1, PointF p2) {
        super();
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public PointF evaluate(float t, PointF p0, PointF p3) {

        PointF point = new PointF();

        point.x = p0.x * (1 - t) * (1 - t) * (1 - t) + 3 * p1.x * t * (1 - t) * (1 - t) + 3 * p2.x * (1 - t) * t * t + p3.x * t * t * t;//实时计算最新的点X坐标
        point.y = p0.y * (1 - t) * (1 - t) * (1 - t) + 3 * p1.y * t * (1 - t) * (1 - t) + 3 * p2.y * (1 - t) * t * t + p3.y * t * t * t;//实时计算最新的点Y坐标
        return point;
    }
}
