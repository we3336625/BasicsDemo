package com.zx.crazyandroid.biz.view.progress_bar.progress_bar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ProgressBar;

import com.zx.crazyandroid.R;
import com.zx.crazyandroid.biz.BaseActivity;

/**
 * progressBar 使用
 */
public class ProgressBarActivity extends BaseActivity {

    private ProgressBar bar;
    private ProgressBar bar2;

    private int status = 0;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                bar.setProgress(status);
                bar2.setProgress(status);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        bar = (ProgressBar) findViewById(R.id.bar);
        bar2 = (ProgressBar) findViewById(R.id.bar2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (++status <= 100) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.i(TAG, "status:  " + status);
                    handler.sendEmptyMessage(1);
                }
            }
        }).start();
    }
}
