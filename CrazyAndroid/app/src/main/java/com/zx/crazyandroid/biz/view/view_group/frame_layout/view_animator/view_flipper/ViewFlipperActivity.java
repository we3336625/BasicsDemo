package com.zx.crazyandroid.biz.view.view_group.frame_layout.view_animator.view_flipper;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import com.zx.crazyandroid.R;
import com.zx.crazyandroid.biz.BaseActivity;

/**
 * viewFlipper 自动播放的图片库
 */
public class ViewFlipperActivity extends BaseActivity {

    ViewFlipper viewFlipper;
    Button btn_prev, btn_next, btn_auto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        btn_prev = (Button) findViewById(R.id.btn_prev);
        btn_next = (Button) findViewById(R.id.btn_next);
        btn_auto = (Button) findViewById(R.id.btn_auto);

        viewFlipper.setInAnimation(this, R.anim.slide_in_right);
        viewFlipper.setOutAnimation(this, R.anim.slide_out_left);

        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showPrevious();
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showNext();
            }
        });

        btn_auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.startFlipping();
            }
        });
    }
}
