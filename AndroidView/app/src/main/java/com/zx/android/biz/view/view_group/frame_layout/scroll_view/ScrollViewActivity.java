package com.zx.android.biz.view.view_group.frame_layout.scroll_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zx.android.R;

/**
 * ScrollView 最多包含一个组件，作用：为该组件添加垂直滚动条
 */
public class ScrollViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
    }
}
