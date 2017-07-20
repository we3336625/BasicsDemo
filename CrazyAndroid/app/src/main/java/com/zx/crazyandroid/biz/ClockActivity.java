package com.zx.crazyandroid.biz;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import com.zx.crazyandroid.R;

public class ClockActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);

        final Button btn_start = (Button) findViewById(R.id.btn_start);
        final Chronometer chronometer = (Chronometer) findViewById(R.id.chrono);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                btn_start.setEnabled(false);
            }
        });

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (SystemClock.elapsedRealtime() - chronometer.getBase() > (5 * 1000)) {
                    chronometer.stop();
                    btn_start.setEnabled(true);
                }
            }
        });
    }
}
