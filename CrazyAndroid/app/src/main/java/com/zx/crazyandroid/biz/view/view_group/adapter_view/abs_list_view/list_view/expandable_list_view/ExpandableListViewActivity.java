package com.zx.crazyandroid.biz.view.view_group.adapter_view.abs_list_view.list_view.expandable_list_view;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zx.crazyandroid.R;
import com.zx.crazyandroid.biz.BaseActivity;

/**
 * 可展开的列表组件
 */
public class ExpandableListViewActivity extends BaseActivity {

    int[] images = new int[]{
            R.drawable.chuxuka,
            R.drawable.weixin,
            R.drawable.zhifubao
    };

    String[] stringTypes = new String[] {
            "one",
            "two",
            "three"
    };

    String[][] strings = new String[][] {
            {"one1","one2","one3"},
            {"two1"},
            {"three1","three2"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view);

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expandable_list_view);
        ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
            // group 个数
            @Override
            public int getGroupCount() {
                return stringTypes.length;
            }

            // child 个数
            @Override
            public int getChildrenCount(int groupPosition) {
                return strings[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return null;
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return null;
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }

            // GroupView 布局
            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LinearLayout linearLayout = new LinearLayout(ExpandableListViewActivity.this);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                linearLayout.setGravity(Gravity.CENTER_VERTICAL);
                ImageView imageView = new ImageView(ExpandableListViewActivity.this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(150, 150);
                layoutParams.setMargins(150, 0, 150, 0);
                imageView.setLayoutParams(layoutParams);
                imageView.setImageResource(images[groupPosition]);
                TextView textView = new TextView(ExpandableListViewActivity.this);
                textView.setText(stringTypes[groupPosition]);
                linearLayout.addView(imageView);
                linearLayout.addView(textView);
                return linearLayout;
            }

            // childView 布局
            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView textView = new TextView(ExpandableListViewActivity.this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150);
                textView.setLayoutParams(layoutParams);
                textView.setPadding(75, 0, 0, 0);
                textView.setTextSize(24);
                textView.setGravity(Gravity.CENTER);
                textView.setText(strings[groupPosition][childPosition]);
                return textView;
            }

            // child 是否可点击
            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }
        };
        expandableListView.setAdapter(adapter);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(ExpandableListViewActivity.this, "第" + (groupPosition + 1) + "组，第" + (childPosition + 1) + "个", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(ExpandableListViewActivity.this, "第" + (groupPosition + 1) + "组", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
