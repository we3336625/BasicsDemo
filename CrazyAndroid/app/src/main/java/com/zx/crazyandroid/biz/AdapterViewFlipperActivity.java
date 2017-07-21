package com.zx.crazyandroid.biz;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.zx.crazyandroid.R;

/**
 * AdapterViewFlipper 实现自动播放图片
 */
public class AdapterViewFlipperActivity extends BaseActivity {

    private int[] images = new int[]{
            R.drawable.bg1,
            R.drawable.bg2,
            R.drawable.bg3,
            R.drawable.bg4,
            R.drawable.bg5,
            R.drawable.bg6
    };

    private AdapterViewFlipper adapterViewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view_flipper);
        adapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.adapter_view_flipper);
        adapterViewFlipper.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return images.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView = new ImageView(AdapterViewFlipperActivity.this);
                imageView.setImageResource(images[position]);
                return imageView;
            }
        });
    }

    /**
     * 上一张
     */
    public void prev(View view) {
        adapterViewFlipper.stopFlipping();
        adapterViewFlipper.showPrevious();
    }

    /**
     * 下一张
     */
    public void next(View view) {
        adapterViewFlipper.stopFlipping();
        adapterViewFlipper.showNext();
    }

    /**
     * 自动播放
     */
    public void auto(View view) {
        adapterViewFlipper.startFlipping();
    }
}
