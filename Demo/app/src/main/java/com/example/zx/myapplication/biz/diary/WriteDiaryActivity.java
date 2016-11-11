package com.example.zx.myapplication.biz.diary;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;

import butterknife.BindView;

public class WriteDiaryActivity extends BaseActivity {

	@BindView(R.id.et_write_diary)
	EditText et_write_diary;

	@BindView(R.id.btn_sava_diary)
	Button btn_sava_diary;

	@BindView(R.id.btn_cancle_diary)
	Button btn_cancle_diary;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_write_diary;
	}

	@Override
	protected void findViews() {
		super.findViews();
		setTitle("写日记");
	}

	@Override
	protected void setupListeners() {
		super.setupListeners();
		btn_sava_diary.setOnClickListener(this);
		btn_cancle_diary.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		switch (view.getId()){
			case R.id.btn_sava_diary:
				saveDiary();
				break;
			case R.id.btn_cancle_diary:
				et_write_diary.setText("");
				break;
			default:
				break;
		}
	}

	private void saveDiary() {
		String content = et_write_diary.getText().toString();
		Long time = System.currentTimeMillis();

	}

	@Override
	protected void initData() {
		super.initData();

	}
}
