package com.example.zx.myapplication.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.zx.myapplication.R;

/**
 * 打电话
 * Created by ex-zhangxiang on 2016/8/9.
 */
public class TelephoneActivity extends BaseActivity {

	private Button mBtnCall;
	private EditText mEtNumber;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_telephone;
	}

	@Override
	protected void findViews() {
		super.findViews();
		setTitle(R.string.tele_title);
		mEtNumber = (EditText) findViewById(R.id.telephone_et_number);
		mBtnCall = (Button) findViewById(R.id.telephone_btn_call);
	}

	@Override
	protected void setupListeners() {
		super.setupListeners();
		mBtnCall.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		switch (view.getId()) {
			case R.id.telephone_btn_call:
				String number = mEtNumber.getText().toString();
				if (number != null && number.length() > 0) {
					Uri uri = Uri.parse("tel:" + number);
					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_CALL);
					intent.setData(uri);
					startNextActivity(intent);
				} else {
					tip(R.string.numberisnull);
				}
				break;
		}
	}
}
