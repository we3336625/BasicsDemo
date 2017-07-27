package com.zx.android.biz.popup_window;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;

import com.zx.android.R;
import com.zx.android.biz.BaseActivity;

/**
 *  popupWindow 使用
 */
public class PopupWindowActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);

        final View view = getLayoutInflater().inflate(R.layout.popup, null);
        final PopupWindow popupWindow = new PopupWindow(view, 500, 500);
        findViewById(R.id.btn_show_pop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 以下拉方式显示
//                popupWindow.showAsDropDown(v);

                // 显示在指定位置
                popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0 );
            }
        });
        view.findViewById(R.id.btn_close_popup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
}
