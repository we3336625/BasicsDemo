package com.zx.crazyandroid.biz;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.StackView;

import com.zx.crazyandroid.R;

/**
 * StackView 叠在一起的图片
 */
public class StackViewActivity extends BaseActivity {

    private StackView stackView;

    private int[] images = new int[] {
            R.drawable.bg1,
            R.drawable.bg2,
            R.drawable.bg3,
            R.drawable.bg4,
            R.drawable.bg5,
            R.drawable.bg6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_view);
        stackView = (StackView) findViewById(R.id.stack_view);
        stackView.setAdapter(new BaseAdapter() {
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
                ImageView imageView = new ImageView(StackViewActivity.this);
                imageView.setImageResource(images[position]);
                return imageView;
            }
        });
    }

    public void stack_prev(View view) {
        stackView.showPrevious();
    }

    public void stack_next(View view) {
        stackView.showNext();
    }
}
