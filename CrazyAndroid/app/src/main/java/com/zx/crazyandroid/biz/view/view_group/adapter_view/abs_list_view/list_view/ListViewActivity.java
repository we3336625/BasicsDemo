package com.zx.crazyandroid.biz.view.view_group.adapter_view.abs_list_view.list_view;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.zx.crazyandroid.R;
import com.zx.crazyandroid.biz.BaseActivity;

public class ListViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        BaseAdapter baseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return 20;
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
                LinearLayout linearLayout = new LinearLayout(ListViewActivity.this);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                linearLayout.setGravity(Gravity.CENTER_VERTICAL);
                ImageView imageView = new ImageView(ListViewActivity.this);
                imageView.setImageResource(R.mipmap.ic_launcher);
                TextView textView = new TextView(ListViewActivity.this);
                textView.setText("------> " + position);

                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(100, 0 , 0, 0);
                textView.setLayoutParams(lp);

                linearLayout.addView(imageView);
                linearLayout.addView(textView);
                return linearLayout;
            }
        };
        listView.setAdapter(baseAdapter);
    }
}
