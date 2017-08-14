package com.zhangboshu.demo.utils;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

/**
 * Created by zhangboshu on 2017/6/7.
 */

public class PointEvaluator implements TypeEvaluator<PointF>{

    @Override
    public PointF evaluate(float fraction, PointF startPoint, PointF endPoint) {

        PointF pointF = new PointF();
        //模仿源码，算出fraction的计算获取相应的值
        pointF.x = startPoint.x + fraction * (endPoint.x - startPoint.x);
        pointF.y = startPoint.y + fraction * (endPoint.y - startPoint.y);

        return pointF;
    }
}
