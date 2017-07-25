package com.zx.crazyandroid.biz.view.view_group.frame_layout.view_animator.view_switcher;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.zx.crazyandroid.R;
import com.zx.crazyandroid.biz.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewSwitcher 实现仿android系统launcher界面
 */
public class ViewSwitcherActivity extends BaseActivity {
    // 每屏显示的应用程序数
    public static final int NUMBER_PER_SCREEN = 12;

    public static class DataItem {
        // 应用程序名称
        public String dataName;
        // 应用程序图标
        public Drawable drawable;
    }

    // 保存系统所有应用程序的list集合
    private List<DataItem> items = new ArrayList<>();
    // 记录当前正在显示第几屏的程序
    private int screenNo = 0;
    // 保存程序所占的总屏数
    private int screenCount;

    private ViewSwitcher viewSwitcher;
    // 创建layoutInflater 对象
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_switcher);

        inflater = LayoutInflater.from(this);

        // 模拟40个应用程序
        for (int i = 0; i < 40; i++) {
            String label = i + "";
            Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
            DataItem item = new DataItem();
            item.dataName = label;
            item.drawable = drawable;
            items.add(item);
        }
        /*
         * 计算应用程序锁站的总屏数
         * items 数量不能整除NUMBER_PER_SCREEN时，取 NUMBER_PER_SCREEN + 1
         */
        screenCount = items.size() % NUMBER_PER_SCREEN == 0 ? items.size() / NUMBER_PER_SCREEN : items.size() / NUMBER_PER_SCREEN + 1;

        viewSwitcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);

        viewSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            // 返回一个GridView 组件
            @Override
            public View makeView() {
                GridView gridView = new GridView(ViewSwitcherActivity.this);
                gridView.setNumColumns(4);
                return gridView;
            }
        });
        // 加载第一屏
        show();
    }

    /**
     * 显示第0页
     */
    private void show() {
        ((GridView) viewSwitcher.getNextView()).setAdapter(adapter);
        viewSwitcher.showPrevious();
    }

    /**
     * 上一页
     * @param view
     */
    public void view_switcher_prev(View view) {
        // 当前屏数不是第一屏时， screenNo-1
        // 是第一屏时，跳到最后一屏
        if (screenNo > 0) {
            screenNo--;
        } else if (screenNo == 0) {
            screenNo = screenCount - 1;
        }
        // 设置动画
        viewSwitcher.setInAnimation(this, android.R.anim.slide_in_left);
        viewSwitcher.setOutAnimation(this, android.R.anim.slide_out_right);
        // 设置adapter
        ((GridView) viewSwitcher.getNextView()).setAdapter(adapter);
        // 显示上一屏
        viewSwitcher.showPrevious();
    }

    /**
     * 下一页
     * @param view
     */
    public void view_switcher_next(View view) {
        // 当前屏不为最后一屏时，screenNo+1
        // 当前屏为最后一屏时，跳到第一屏
        if (screenNo < screenCount - 1) {
            screenNo++;
        } else if (screenNo == screenCount - 1) {
            screenNo = 0;
        }
        // 设置动画
        viewSwitcher.setInAnimation(this, R.anim.slide_in_right);
        viewSwitcher.setOutAnimation(this, R.anim.slide_out_left);
        // 设置动画
        ((GridView) viewSwitcher.getNextView()).setAdapter(adapter);
        viewSwitcher.showNext();
    }

    /**
     * 每一屏的gridView adapter
     */
    BaseAdapter adapter = new BaseAdapter() {
        // 每一屏的显示个数
        // 当为最后一屏时，items个数 不能整除NUMBER_PER_SCREEN：count为items个数除NUMBER_PER_SCREEN的余数
        @Override
        public int getCount() {
            if (screenNo == screenCount - 1 && items.size() % NUMBER_PER_SCREEN != 0)
                return items.size() % NUMBER_PER_SCREEN;
            return NUMBER_PER_SCREEN;
        }

        // 通过当前屏数screenNo 计算第position个列表项的数据
        @Override
        public DataItem getItem(int position) {
            return items.get(screenNo * NUMBER_PER_SCREEN + position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (convertView == null)
                view = inflater.inflate(R.layout.labelicon, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
            TextView textView = (TextView) view.findViewById(R.id.textview);

            imageView.setImageDrawable(getItem(position).drawable);
            textView.setText(getItem(position).dataName);
            return view;
        }
    };

}
