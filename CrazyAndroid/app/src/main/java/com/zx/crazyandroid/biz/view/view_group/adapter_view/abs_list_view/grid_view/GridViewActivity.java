package com.zx.crazyandroid.biz.view.view_group.adapter_view.abs_list_view.grid_view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zx.crazyandroid.R;
import com.zx.crazyandroid.biz.BaseActivity;

/**
 *  GridView 点击item放大图片
 */
public class GridViewActivity extends BaseActivity {
    private GridView gridView;
    private ImageView imageView;

    int[] images = new int[]{
            R.drawable.zongjine,
            R.drawable.zhifubao,
            R.drawable.xinyongka,
            R.drawable.xianjin,
            R.drawable.weixin,
            R.drawable.jieru,
            R.drawable.jiechu,
            R.drawable.chuxuka
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        gridView = (GridView) findViewById(R.id.grid_view);
        imageView = (ImageView) findViewById(R.id.imageView);

        gridView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return images.length;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView = new ImageView(GridViewActivity.this);
                imageView.setImageResource(images[position]);

                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(150, 150);
                imageView.setLayoutParams(lp);

                return imageView;
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(images[position]);
            }
        });

    }
}
