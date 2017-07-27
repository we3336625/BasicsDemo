package com.zx.android.biz.view.view_group.frame_layout.view_animator.view_switcher.text_switcher;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.zx.android.R;
import com.zx.android.biz.BaseActivity;

/**
 * textSwitcher 文本切换器
 */
public class TextSwitcherActivity extends BaseActivity {

    private TextSwitcher textSwitcher;

    int count;

    String[] strings = new String[]{
            "111111111111",
            "222222222222",
            "333333333333",
            "444444444444",
            "555555555555"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_switcher);

        textSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);

        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(TextSwitcherActivity.this);
                textView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
                textView.setTextSize(24);
                return textView;
            }
        });
        textSwitcher.setText(strings[count % strings.length]);
        textSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = ++count % strings.length;
                textSwitcher.setText(strings[a]);
            }
        });
    }
}
