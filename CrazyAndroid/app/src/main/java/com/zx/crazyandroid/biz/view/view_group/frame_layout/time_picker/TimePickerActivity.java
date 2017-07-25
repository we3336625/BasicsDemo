package com.zx.crazyandroid.biz.view.view_group.frame_layout.time_picker;

import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.Toast;

import com.zx.crazyandroid.R;
import com.zx.crazyandroid.biz.BaseActivity;

/**
 * timePicker  时间选择器
 */
public class TimePickerActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(TimePickerActivity.this, hourOfDay + "hour"+ minute + "minute", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
