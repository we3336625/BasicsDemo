package com.zx.android.biz.view.text_view.edit_text.auto_complete_text_view;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import com.zx.android.R;
import com.zx.android.biz.BaseActivity;

/**
 * 自动补全textView
 */
public class AutoCompleteActivity extends BaseActivity {
    private AutoCompleteTextView auto_complete;
    private MultiAutoCompleteTextView multi_auto_complete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);

        String[] strings = new String[] {
                "1111",
                "1112",
                "1113",
                "1114"
        };

        auto_complete = (AutoCompleteTextView) findViewById(R.id.auto_complete);
        multi_auto_complete = (MultiAutoCompleteTextView) findViewById(R.id.multi_auto_complete);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, strings);
        auto_complete.setAdapter(arrayAdapter);
        multi_auto_complete.setAdapter(arrayAdapter);
        multi_auto_complete.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
