package com.zx.viewtest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Scroller;

/**
 * 【类功能说明】
 * 当滑动距离大于 1/3屏幕 滑动到下一页
 *
 * @author zhangxiang
 * @version v 1.4.8 2017/8/10 上午11:03 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 */
public class ScrollTestView extends ViewGroup {
    public ScrollTestView(Context context) {
        super(context);
    }

    public ScrollTestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ScrollTestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(
                Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        mScreenHeight = dm.heightPixels;
        mScroller = new Scroller(context);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        MarginLayoutParams mlp = (MarginLayoutParams) getLayoutParams();
        mlp.height = mScreenHeight * childCount;
        setLayoutParams(mlp);

        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            if (childView.getVisibility() != View.GONE)
                childView.layout(l, mScreenHeight * i, r, mScreenHeight * (i + 1));
        }
    }

    // 屏幕宽度
    private int mScreenHeight;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View childView = getChildAt(i);
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
        }

    }

    // 记录最后停留位置的Y
    private int mLastY;
    // 记录开始位置的Y
    private int mStart;
    // 记录最后抬起位置的Y
    private int mEndY;
    private Scroller mScroller;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastY = y;
                mStart = getScrollY();
                break;
            case MotionEvent.ACTION_MOVE:
                if (!mScroller.isFinished())
                    mScroller.abortAnimation();
                // 滑动的距离
                int dy = mLastY - y;
                // 防止 从第一个view 往下滑
                if (getScrollY() < 0)
                    dy = 0;
                // 防止 从最后一个view 往上滑
                if (getScrollY() > getHeight() - mScreenHeight)
                    dy = 0;
                scrollBy(0, dy);
                mLastY = y;

                break;
            case MotionEvent.ACTION_UP:
                mEndY = getScrollY();
                // 从点击到抬起滑动的距离
                int dScrollY = mEndY - mStart;
                // 往下滑
                if (dScrollY > 0) {
                    // 滑动距离小于 1/3屏幕 从当前位置往上滑 返回起始位置
                    if (dScrollY < mScreenHeight / 3)
                        mScroller.startScroll(0, getScrollY(), 0, -dScrollY);
                    // 滑动距离大于 1/3屏幕 从当前位置滑动剩余距离
                    else
                        mScroller.startScroll(0, getScrollY(), 0, mScreenHeight - dScrollY);
                // 往上滑
                } else {
                    // 距离小于 1/3屏幕
                    if (-dScrollY < mScreenHeight / 3)
                        mScroller.startScroll(0, getScrollY(), 0, -dScrollY);
                    else
                        mScroller.startScroll(0, getScrollY(), 0, -mScreenHeight - dScrollY);
                }
                break;
        }
        postInvalidate();
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            scrollTo(0, mScroller.getCurrY());
        }
        postInvalidate();
    }
}
