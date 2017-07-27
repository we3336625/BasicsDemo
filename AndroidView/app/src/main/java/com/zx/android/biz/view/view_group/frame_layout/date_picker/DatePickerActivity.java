package com.zx.android.biz.view.view_group.frame_layout.date_picker;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import com.zx.android.R;
import com.zx.android.biz.BaseActivity;

import java.util.Calendar;

/**
 * datePicker 日期选择器
 */
public class DatePickerActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DATE);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(DatePickerActivity.this, year + "year" + monthOfYear + "month" + dayOfMonth + "day", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
