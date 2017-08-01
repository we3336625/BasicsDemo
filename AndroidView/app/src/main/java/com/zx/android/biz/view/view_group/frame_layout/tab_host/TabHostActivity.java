package com.zx.android.biz.view.view_group.frame_layout.tab_host;

import android.os.Bundle;
import android.widget.TabHost;

import com.zx.android.R;
import com.zx.android.biz.BaseActivity;

/**
 * <t>选项卡 TabHost</t>
 *
 * 使用TabHost的一般步骤如下：
 * 1.在界面布局中定义TabHost组件，并为该组件定义该选项卡的内容
 * 2.Activity 应该继承 TabActivity
 * 3.调用TabActivity的getTabHost()方法获得TabHost对象
 * 4.通过TabHost对象的方法来创建、添加选项卡
 *
 * <b>android 3.0 废弃，建议使用ActionBar + ViewPager + fragment</b>
 */
public class TabHostActivity extends BaseActivity {

    TabHost
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host);
    }
}
