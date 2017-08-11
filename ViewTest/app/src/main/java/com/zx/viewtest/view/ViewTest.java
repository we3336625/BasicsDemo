package com.zx.viewtest.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 【类功能说明】
 *
 * @author zhangxiang
 * @version v 1.4.8 2017/8/8 下午5:45 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 */
public class ViewTest extends View {
    public ViewTest(Context context) {
        super(context);
    }

    public ViewTest(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewTest(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ViewTest(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    // 组件大小改变时回调
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.i("test", "onSizeChanged");
    }

    // 回调该方法来确定显示的位置
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.i("test", "onLayout");
    }

    // 回调该方法来进行测量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measureTest(200, widthMeasureSpec), measureTest(200, heightMeasureSpec));
        Log.i("test", "onMeasure");
    }

    // 从XML加载组件后回调
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.i("test", "onFinishInflate");
    }

    public int measureTest(int size, int measureSpec) {
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
}
