package com.zx.crazyandroid.biz;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.zx.crazyandroid.R;

/**
 * spinner: xml 通过entries设置数据
 *          java setAdapter
 */
public class SpinnerActivity extends BaseActivity {

    private Spinner spinner;

    String[] strings = new String[]{
            "one",
            "two",
            "three"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<String>(SpinnerActivity.this, android.R.layout.simple_list_item_multiple_choice, strings));
    }
}
