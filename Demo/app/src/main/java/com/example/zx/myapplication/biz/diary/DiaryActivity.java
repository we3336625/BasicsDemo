package com.example.zx.myapplication.biz.diary;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by ex-zhangxiang on 2016/9/7.
 */
public class DiaryActivity extends BaseActivity {

	@BindView(R.id.btn_new_diary)
	Button btn_new_diary;

	@BindView(R.id.btn_delete_diary)
	Button btn_delete_diary;

	@BindView(R.id.listview_diary)
	ListView listview_diary;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_diary;
	}

	@Override
	protected void findViews() {
		super.findViews();
		setTitle("日记列表");
	}

	@Override
	protected void initData() {
		super.initData();
	}

	@Override
	protected void setupListeners() {
		super.setupListeners();
		btn_new_diary.setOnClickListener(this);
		btn_delete_diary.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		switch (view.getId()){
			case R.id.btn_new_diary:
				startNextActivity(WriteDiaryActivity.class);
				break;
			case R.id.btn_delete_diary:
				break;
			default:
				break;
		}
	}
}
