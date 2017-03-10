package com.example.zx.myapplication.biz.custom_view;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;

import butterknife.BindView;

/**
 * [自定义view]
 *
 * @author ex-zhangxiang
 * @version v 1.0.0 2017/1/16 10:10 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 */
public class CustomViewActivity extends BaseActivity{
    @BindView(R.id.custom_view_circle)
    CustomView customView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_custom_view;
    }

    @Override
    protected void findViews() {
        super.findViews();
        setTitle(R.string.custom_view);

        new Thread(customView).start();
    }
}
