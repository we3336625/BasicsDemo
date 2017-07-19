/*
 *
 *  * 乡邻小站
 *  *   *Copyright (c) 2017 XiangLin,Inc.All Rights Reserved.
 *
 */

package com.zx.crazyandroid.biz;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.zx.crazyandroid.R;

import java.util.Timer;
import java.util.TimerTask;

public class FrameLayoutActivity extends BaseActivity {

    int currentColor = 0;

    int[] color = new int[]{
            R.color.color1,
            R.color.color2,
            R.color.color3,
            R.color.color4,
            R.color.color5,
            R.color.color6,
            R.color.color7,
            R.color.color8
    };

    int[] textView = new int[]{
            R.id.tv1,
            R.id.tv2,
            R.id.tv3,
            R.id.tv4,
            R.id.tv5,
            R.id.tv6,
            R.id.tv7,
            R.id.tv8
    };

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1){
                for (int i = 0; i < textView.length; i++) {
                    textViews[i].setBackgroundResource(color[(i + currentColor) % textView.length]);
                }
                currentColor++;
            }
            super.handleMessage(msg);
        }
    };

    TextView[] textViews = new TextView[textView.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
        for (int i = 0; i < textView.length; i++) {
            textViews[i] = (TextView) findViewById(textView[i]);
        }

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(1);
            }
        },0,300);
    }
}
