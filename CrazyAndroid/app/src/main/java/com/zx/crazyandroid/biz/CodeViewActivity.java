package com.zx.crazyandroid.biz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 【类功能说明】
 * java 代码 写UI
 *
 * @author zhangxiang
 * @version v 1.0 2017/7/18 下午4:17 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 */
public class CodeViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(linearLayout);
        final TextView textView = new TextView(this);
        Button button = new Button(this);
        button.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        button.setText("show");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
                Date date = new Date();
                String str = simpleDateFormat.format(date);
                textView.setText(str);
            }
        });

        linearLayout.addView(textView);
        linearLayout.addView(button);
    }
}
