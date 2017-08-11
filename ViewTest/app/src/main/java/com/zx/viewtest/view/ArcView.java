package com.zx.viewtest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * 【类功能说明】
 *
 * @author zhangxiang
 * @version v 1.4.8 2017/8/9 下午4:55 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 */
public class ArcView extends View {
    public ArcView(Context context) {
        super(context);
    }

    int mCircleXY;
    float mRadius;

    RectF mArcRextF;

    public ArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        int length = 500;
        mCircleXY = length / 2;
        mRadius = (float) (length * 0.5 / 2);
        mArcRextF = new RectF((float) (length * 0.1), (float) (length * 0.1), (float) (length * 0.9), (float) (length * 0.9));
    }

    public ArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measureTest(500, widthMeasureSpec), measureTest(500, heightMeasureSpec));
    }

    private int measureTest(int size, int measureSpec) {
        int result = size;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        switch (specMode) {
            case MeasureSpec.UNSPECIFIED:
                result = size;
                break;
            case MeasureSpec.AT_MOST:
                result = Math.min(result, specSize);
                break;
            case MeasureSpec.EXACTLY:
                result = specSize;
                break;
        }
        return result;
    }

    float mSweepValue;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint arcPaint = new Paint();
        arcPaint.setColor(Color.RED);
        arcPaint.setStyle(Paint.Style.STROKE);
        arcPaint.setAntiAlias(true);
        canvas.drawArc(mArcRextF, 270, mSweepValue, false, arcPaint);

        Paint circlePaint = new Paint();
        circlePaint.setColor(Color.GREEN);
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, circlePaint);

        setSweepValue();
    }

    public void setSweepValue() {
        mSweepValue = mSweepValue + 60;
        if (mSweepValue > 360)
            mSweepValue = 0;
        this.postInvalidateDelayed(500);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Toast.makeText(getContext(), "ArcView---", Toast.LENGTH_SHORT).show();
        return false;
    }
}
