package com.example.zx.myapplication.biz.Telephone;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;

/**
 * 打电话
 * Created by ex-zhangxiang on 2016/8/9.
 */
public class TelephoneActivity extends BaseActivity implements TelephoneContract.View{

	private Button mBtnCall;
	private EditText mEtNumber;
	TelephoneContract.Presenter mPresenter;

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
		new TelephonePresenter(this);
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

				mPresenter.startToActivity(number);

				break;
		}
	}

	@Override
	public void showErrorTip() {
		tip(R.string.numberisnull);
	}

	@Override
	public void toActivity(Intent intent) {
		startNextActivity(intent);
	}

	@Override
	public void setPresenter(TelephoneContract.Presenter presenter) {
		mPresenter = presenter;
	}
}
