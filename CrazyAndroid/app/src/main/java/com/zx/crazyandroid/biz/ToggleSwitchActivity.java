package com.zx.crazyandroid.biz;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.zx.crazyandroid.R;

public class ToggleSwitchActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener {
    private ToggleButton toggle;
    private Switch switch_btn;
    private LinearLayout linear_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_switch);
        toggle = (ToggleButton) findViewById(R.id.toggle_btn);
        switch_btn = (Switch) findViewById(R.id.switch_btn);
        linear_layout = (LinearLayout) findViewById(R.id.linear_layout);
        toggle.setOnCheckedChangeListener(this);
        switch_btn.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            linear_layout.setOrientation(LinearLayout.HORIZONTAL);
            toggle.setChecked(true);
            switch_btn.setChecked(true);
        } else {
            linear_layout.setOrientation(LinearLayout.VERTICAL);
            toggle.setChecked(false);
            switch_btn.setChecked(false);
        }
    }
}
