package com.zx.viewtest.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zx.viewtest.R;

/**
 * 【类功能说明】
 *
 * @author zhangxiang
 * @version v 1.4.8 2017/8/9 下午2:53 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 */
public class TopBar extends RelativeLayout {

    private Button mLeftButton;
    private Button mRightButton;
    private TextView mTitle;

    public TopBar(Context context) {
        super(context);
    }

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        // 获取资源文件
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        // 得到相应属性
        int leftTextColor = typedArray.getColor(R.styleable.TopBar_leftTextColor, 0);
        Drawable leftBackground = typedArray.getDrawable(R.styleable.TopBar_leftBackground);
        String leftText = typedArray.getString(R.styleable.TopBar_leftText);
        float leftTextSize = typedArray.getDimension(R.styleable.TopBar_leftTextSize, 10);

        float titleTextSize = typedArray.getDimension(R.styleable.TopBar_titleTextSize, 10);
        String titleText = typedArray.getString(R.styleable.TopBar_titleText);
        int titleTextColor = typedArray.getColor(R.styleable.TopBar_titleTextColor, 0);

        int rightTextColor = typedArray.getColor(R.styleable.TopBar_rightTextColor, 0);
        String rightText = typedArray.getString(R.styleable.TopBar_rightText);
        float rightTextSize = typedArray.getDimension(R.styleable.TopBar_rightTextSize, 10);
        Drawable rightBackground = typedArray.getDrawable(R.styleable.TopBar_rightBackground);
        // 资源回收
        typedArray.recycle();

        mLeftButton = new Button(context);
        mRightButton = new Button(context);
        mTitle = new TextView(context);

        mLeftButton.setTextColor(leftTextColor);
        mLeftButton.setText(leftText);
        mLeftButton.setBackground(leftBackground);
        mLeftButton.setTextSize(leftTextSize);
        mLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onLeftClick();
            }
        });

        mTitle.setText(titleText);
        mTitle.setTextSize(titleTextSize);
        mTitle.setTextColor(titleTextColor);
        mTitle.setGravity(Gravity.CENTER);
        mTitle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onTitleClick();
            }
        });

        mRightButton.setText(rightText);
        mRightButton.setTextColor(rightTextColor);
        mRightButton.setTextSize(rightTextSize);
        mRightButton.setBackground(rightBackground);
        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onRightClick();
            }
        });

        LayoutParams leftLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        leftLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        mLeftButton.setLayoutParams(leftLayoutParams);
        addView(mLeftButton);

        LayoutParams titleLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        titleLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        mTitle.setLayoutParams(titleLayoutParams);
        addView(mTitle);

        LayoutParams rightLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        rightLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        mRightButton.setLayoutParams(rightLayoutParams);
        addView(mRightButton);

    }

    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private TopOnClickListener mClickListener;

    /**
     * 暴露一个方法用来注册接口
     *
     * @param clickListener TopOnClickListener
     */
    public void setTopOnClickListener(TopOnClickListener clickListener) {
        mClickListener = clickListener;
    }

    /**
     * 回调接口
     */
    public interface TopOnClickListener {
        void onRightClick();

        void onLeftClick();

        void onTitleClick();
    }

    // left button
    public static final int LEFT_BUTTON_VISIBLE = 0;
    // title
    public static final int TITLE_VISIBLE = 1;
    // right button
    public static final int RIGHT_BUTTON_VISIBLE = 2;

    /**
     * 设置view的显示与否
     *
     * @param id   用来区分view
     * @param flag 区分是否显示
     */
    public void setVisible(int id, boolean flag) {
        if (flag) {
            switch (id) {
                case LEFT_BUTTON_VISIBLE:
                    mLeftButton.setVisibility(View.VISIBLE);
                    break;
                case TITLE_VISIBLE:
                    mTitle.setVisibility(View.VISIBLE);
                    break;
                case RIGHT_BUTTON_VISIBLE:
                    mRightButton.setVisibility(View.VISIBLE);
                    break;
            }
        } else {
            switch (id) {
                case LEFT_BUTTON_VISIBLE:
                    mLeftButton.setVisibility(View.GONE);
                    break;
                case TITLE_VISIBLE:
                    mTitle.setVisibility(View.GONE);
                    break;
                case RIGHT_BUTTON_VISIBLE:
                    mRightButton.setVisibility(View.GONE);
                    break;
            }
        }
    }

}
