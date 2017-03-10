package com.example.zx.myapplication.biz.custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.zx.myapplication.utils.ScreenUtils;

/**
 * [类功能说明]
 *
 * @author ex-zhangxiang
 * @version v 1.0.0 2017/1/16 10:27 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 */
public class CustomView extends View implements Runnable {

    private Paint mPaint;
    private Context mContext;
    private int mRadius = 200;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initPaint();
    }

    private void initPaint() {
        // 抗锯齿
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        /*
         *画笔样式分三种：
         * 1.Paint.Style.STROKE：描边
         * 2.Paint.Style.FILL_AND_STROKE：描边并填充
         * 3.Paint.Style.FILL：填充
         */
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.GRAY);
        /**
         * 设置描边的粗细，单位：像素px
         */
        mPaint.setStrokeWidth(5);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(ScreenUtils.getScreenWidth(mContext) / 2, ScreenUtils.getScreenHeight(mContext) / 2, mRadius, mPaint);
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (mRadius <= 200) {
                    mRadius += 5;
                    postInvalidate();
                } else {
                    mRadius = 0;
                }
                Thread.sleep(40);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
