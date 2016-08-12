package com.tdroid.imageselector.library.imageselelctor;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;


/**
 * @Class: SquareImageView
 * @Description:
 * @author: lling(www.liuling123.com)
 * @Date: 2015/11/5
 */
public class SelectorImageView extends ImageView {

    private Context mContext;
    private int mWidth=200;
    public SelectorImageView(Context context) {
        this(context, null);
    }

    public SelectorImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SelectorImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(mWidth, mWidth);
    }

}
