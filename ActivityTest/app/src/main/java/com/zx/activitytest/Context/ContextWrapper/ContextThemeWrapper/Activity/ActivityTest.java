/*
 *
 *  * 乡邻小站
 *  *   *Copyright (c) 2017 XiangLin,Inc.All Rights Reserved.
 *
 */

package com.zx.activitytest.Context.ContextWrapper.ContextThemeWrapper.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.zx.activitytest.Context.ContextWrapper.ContextThemeWrapper.Activity.ListActivity.ListActivityTest;
import com.zx.activitytest.db.bean.TestBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 【类功能说明】
 *
 * @author zhangxiang
 * @version v 1.4.8 2017/7/28 上午9:56 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 */
public class ActivityTest extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        Button button = new Button(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new TestBean());
            }
        });
        button.setText("activity  test");

        Button button1 = new Button(this);
        button1.setText("open list ACTIVITY");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityTest.this, ListActivityTest.class);
                startActivity(intent);
            }
        });
        linearLayout.addView(button);
        linearLayout.addView(button1);
        setContentView(linearLayout);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void event(TestBean bean) {
        Log.i("ActivityTest", "ActivityTest---------------");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
}
