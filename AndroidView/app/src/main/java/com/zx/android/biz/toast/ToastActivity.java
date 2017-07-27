package com.zx.android.biz.toast;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zx.android.R;
import com.zx.android.biz.BaseActivity;

/**
 * Toast 带图片的消息提示
 */
public class ToastActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
    }

    public void simple(View view) {
        Toast.makeText(this, "simple  Toast", Toast.LENGTH_SHORT).show();
    }

    public void picture(View view) {
        Toast toast = new Toast(this);
        toast.setGravity(Gravity.LEFT, 0, 0);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.bg1);
        TextView textView = new TextView(this);
        textView.setText("123456");
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        ll.addView(imageView);
        ll.addView(textView);
        toast.setView(ll);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }
}
