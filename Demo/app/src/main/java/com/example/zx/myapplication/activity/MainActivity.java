package com.example.zx.myapplication.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zx.myapplication.R;

/**
 * 主界面
 * Created by ex-zhangxiang on 2016/7/22.
 */
public class MainActivity extends BaseActivity {

	public static final String TAG = "MainActivity";

	private Button mBtnSQLite;
	private Button mBtnImageSelector;
	private Button mBtnTelephonoe;
	private Button mBtnSendSMS;
	private Button mBtnFileStore;

	@Override
	protected void findViews() {
		super.findViews();
		setTitle(R.string.main);
		initTitleButton();
		mBtnSQLite = (Button) findViewById(R.id.main_sqlite);
		mBtnImageSelector = (Button) findViewById(R.id.main_imageselector);
		mBtnTelephonoe = (Button) findViewById(R.id.main_telephone);
		mBtnSendSMS = (Button) findViewById(R.id.main_sendsms);
		mBtnFileStore = (Button) findViewById(R.id.main_filestore);
	}

	private void initTitleButton() {
		TextView tvBack = (TextView) findViewById(R.id.back);
		tvBack.setVisibility(View.INVISIBLE);
	}

	@Override
	protected int getLayoutId() {
		return R.layout.activity_main;
	}

	@Override
	protected void setupListeners() {
		super.setupListeners();
		mBtnSQLite.setOnClickListener(this);
		mBtnImageSelector.setOnClickListener(this);
		mBtnTelephonoe.setOnClickListener(this);
		mBtnSendSMS.setOnClickListener(this);
		mBtnFileStore.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		switch (view.getId()) {
			case R.id.main_sqlite:
				startNextActivity(SQLiteActivity.class);
				break;
			case R.id.main_imageselector:
				startNextActivity(ImageSelectorActivity.class);
				break;
			case R.id.main_telephone:
				startNextActivity(TelephoneActivity.class);
				break;
			case R.id.main_sendsms:
				startNextActivity(SendSMSActivity.class);
				break;
			case R.id.main_filestore:
				startNextActivity(FileStoreActivity.class);
				break;
			default:
				break;
		}
	}
}
