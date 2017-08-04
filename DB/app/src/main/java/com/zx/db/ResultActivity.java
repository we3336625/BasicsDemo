package com.zx.db;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ListView listView = (ListView) findViewById(R.id.listView);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Bundle");
        if (bundle == null) return;
        final ArrayList<Map<String, String>> list = (ArrayList<Map<String, String>>) bundle.getSerializable("data");

        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Map<String, String> getItem(int position) {
                return list.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LinearLayout linearLayout = new LinearLayout(ResultActivity.this);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(300, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(50,10,0,10);

                TextView tvWord = new TextView(ResultActivity.this);
                tvWord.setText(getItem(position).get("word"));
                tvWord.setLayoutParams(lp);

                TextView tvDetail = new TextView(ResultActivity.this);
                tvDetail.setText(getItem(position).get("detail"));
                tvDetail.setLayoutParams(lp);

                linearLayout.addView(tvWord);
                linearLayout.addView(tvDetail);

                return linearLayout;
            }
        });

    }
}
