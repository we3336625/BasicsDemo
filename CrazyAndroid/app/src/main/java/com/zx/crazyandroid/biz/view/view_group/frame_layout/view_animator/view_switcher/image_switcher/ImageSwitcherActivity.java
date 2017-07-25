package com.zx.crazyandroid.biz.view.view_group.frame_layout.view_animator.view_switcher.image_switcher;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.zx.crazyandroid.R;
import com.zx.crazyandroid.biz.BaseActivity;

/**
 * imageSwitcher 支持动画的图片浏览
 */
public class ImageSwitcherActivity extends BaseActivity {

    private GridView gridView;
    private ImageSwitcher imageSwitcher;

    int[] images = new int[]{
            R.drawable.zongjine,
            R.drawable.zhifubao,
            R.drawable.xinyongka,
            R.drawable.xianjin,
            R.drawable.weixin,
            R.drawable.jieru,
            R.drawable.jiechu,
            R.drawable.chuxuka,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher);

        gridView = (GridView) findViewById(R.id.gridView);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.image_switcher);
        imageSwitcher.setInAnimation(this, R.anim.slide_in_right);
        imageSwitcher.setOutAnimation(this, R.anim.slide_out_left);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(ImageSwitcherActivity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
                imageView.setLayoutParams(lp);
                return imageView;
            }
        });
        gridView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return images.length;
            }

            @Override
            public Integer getItem(int position) {
                return images[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView = new ImageView(ImageSwitcherActivity.this);
                imageView.setImageResource(getItem(position));
                ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                imageView.setLayoutParams(lp);
                return imageView;
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageSwitcher.setImageResource(images[position]);
            }
        });

    }
}
