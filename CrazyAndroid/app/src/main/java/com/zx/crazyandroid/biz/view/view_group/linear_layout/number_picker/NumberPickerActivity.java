package com.zx.crazyandroid.biz.view.view_group.linear_layout.number_picker;

import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.zx.crazyandroid.R;
import com.zx.crazyandroid.biz.BaseActivity;

/**
 * numberPicker  数字选择器
 */
public class NumberPickerActivity extends BaseActivity {

    NumberPicker numberPicker1, numberPicker2;

    int min = 0;
    int max = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_picker);

        numberPicker1 = (NumberPicker) findViewById(R.id.numberPicker1);
        numberPicker2 = (NumberPicker) findViewById(R.id.numberPicker2);

        numberPicker1.setMinValue(0);
        numberPicker1.setMaxValue(50);
        numberPicker1.setValue(0);
        numberPicker1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                min = newVal;
                showTip();
            }
        });

        numberPicker2.setMinValue(50);
        numberPicker2.setMaxValue(100);
        numberPicker2.setValue(50);
        numberPicker2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                max = newVal;
                showTip();
            }
        });
    }

    private void showTip() {
        Toast.makeText(this, "min:  " + min + "\nmax:  " + max, Toast.LENGTH_SHORT).show();
    }
}
