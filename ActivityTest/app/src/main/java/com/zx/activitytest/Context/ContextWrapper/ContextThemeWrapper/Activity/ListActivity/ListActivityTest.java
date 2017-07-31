/*
 *
 *  * 乡邻小站
 *  *   *Copyright (c) 2017 XiangLin,Inc.All Rights Reserved.
 *
 */

package com.zx.activitytest.Context.ContextWrapper.ContextThemeWrapper.Activity.ListActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zx.activitytest.db.bean.TestBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 【类功能说明】
 *
 * @author zhangxiang
 * @version v 1.4.8 2017/7/28 上午10:02 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 */
public class ListActivityTest extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        Button button = new Button(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new TestBean());
            }
        });
        button.setText("list  activity");
        setContentView(button);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void event(TestBean bean) {
        Log.i("ListActivityTest", "ListActivityTest---------------");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
}
