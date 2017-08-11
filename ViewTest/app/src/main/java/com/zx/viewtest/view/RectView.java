package com.zx.viewtest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Toast;

/**
 * 【类功能说明】
 *
 * @author zhangxiang
 * @version v 1.4.8 2017/8/10 上午9:45 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 */
public class RectView extends BaseView {

    // rect 宽
    private float mRectWight;
    // rect 个数
    private int mRectCount;
    // rect 之间的距离
    private int offset;
    // 画笔
    private Paint mPain;

    public RectView(Context context) {
        super(context);
    }

    public RectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mHeight = 500;
        mRectWight = 50;
        mRectCount = 20;
        offset = 5;
        mPain = new Paint();
        LinearGradient linearGradient = new LinearGradient(0, 0, mRectWight, mHeight, Color.YELLOW, Color.BLUE, Shader.TileMode.CLAMP);
        mPain.setShader(linearGradient);
    }

    public RectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < mRectCount; i++) {
            canvas.drawRect(offset * (i + 1) + mRectWight * i,
                    currentHeight(),
                    offset * (i + 1) + mRectWight * (i + 1),
                    mHeight,
                    mPain);
        }

        postInvalidateDelayed(300);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Toast.makeText(getContext(), "RectView---", Toast.LENGTH_SHORT).show();
        return false;
    }

    private float currentHeight() {
        return (float) (mHeight * Math.random());
    }


}
