package com.tdroid.imageselector.library.imageselelctor;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Administrator on 2015/12/1.
 */
public class NeverScrollGridView extends GridView {
    public NeverScrollGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NeverScrollGridView(Context context) {
        super(context);
    }

    public NeverScrollGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));


        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
