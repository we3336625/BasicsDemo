package com.zx.viewtest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 【类功能说明】
 *
 * @author zhangxiang
 * @version v 1.4.8 2017/8/9 上午11:21 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 */
public class MyTextView extends TextView {
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint1 = new Paint();
        paint1.setColor(getResources().getColor(android.R.color.holo_blue_light));
        paint1.setStyle(Paint.Style.FILL);

        Paint paint2 = new Paint();
        paint2.setColor(getResources().getColor(android.R.color.holo_red_light));
        paint2.setStyle(Paint.Style.FILL);

        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint1);
        canvas.drawRect(10, 10, getMeasuredWidth() - 10, getMeasuredHeight() - 10, paint2);
        canvas.save();

        super.onDraw(canvas);

        if (mMatrix != null) {
            mTranslate += mViewWidth/5;
            if (mTranslate > 2*mViewWidth) {
                mTranslate =-mViewWidth;
            }
            mMatrix.setTranslate(mTranslate,0);
            mLinearGradient.setLocalMatrix(mMatrix);
            postInvalidateDelayed(100);
        }

    }

    int mViewWidth;
    Paint mPaint;
    LinearGradient mLinearGradient;
    Matrix mMatrix;
    int mTranslate;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();
            if (mViewWidth > 0) {
                mPaint = getPaint();
                mLinearGradient = new LinearGradient(0, 0, mViewWidth, 0 ,new int[] {
                        Color.BLUE,
                        0xffffff,
                        Color.BLUE
                }, null , Shader.TileMode.CLAMP);
                mPaint.setShader(mLinearGradient);
                mMatrix = new Matrix();
            }
        }
    }
}
