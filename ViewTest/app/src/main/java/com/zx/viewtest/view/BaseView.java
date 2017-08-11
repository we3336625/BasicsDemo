package com.zx.viewtest.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 【类功能说明】
 *
 * @author zhangxiang
 * @version v 1.4.8 2017/8/10 上午9:49 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 */
public class BaseView extends View {
    protected int mWidth = 200;
    protected int mHeight = 200;

    public BaseView(Context context) {
        super(context);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureTest(mWidth, widthMeasureSpec), measureTest(mHeight, heightMeasureSpec));
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
