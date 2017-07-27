package com.zx.android.biz.view.progress_bar.abs_seek_bar.seek_bar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.zx.android.R;
import com.zx.android.biz.BaseActivity;

/**
 * seekBar  控制图片透明度
 */
public class SeekBarActivity extends BaseActivity {

    private ImageView imageView;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);
        imageView = (ImageView) findViewById(R.id.image);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                imageView.setImageAlpha(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
