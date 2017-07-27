package com.zx.android.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 【类功能说明】
 * 自定义view circle
 * 跟随手指而移动
 * 抬起消失
 *
 * @author zhangxiang
 * @version v 1.0 2017/7/19 上午10:27 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 *
 */
public class DrawView extends View {
    // 画笔
    Paint paint = new Paint();
    // 手指是否抬起
    boolean isUp = true;

    // circle 圆心的位置 X Y
    float currentX = 30;
    float currentY = 30;

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 设置画笔颜色
        paint.setColor(isUp ? Color.WHITE : Color.RED);
        // 绘制 一个circle
        canvas.drawCircle(currentX, currentY, 20, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // X Y 跟随手指移动
        currentX = event.getX();
        currentY = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                isUp = false;
                break;
            case MotionEvent.ACTION_UP:
                isUp = true;
                break;
        }
        // 重绘
        invalidate();
        // 返回true表明该处理方法已经处理该事件
        return true;
    }
}
