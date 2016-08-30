package com.example.zx.myapplication.biz.main;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;
import com.example.zx.myapplication.biz.filestore.FileStoreActivity;
import com.example.zx.myapplication.biz.ImageSelector.ImageSelectorActivity;
import com.example.zx.myapplication.biz.SQLite.SQLiteActivity;
import com.example.zx.myapplication.biz.selectbank.SelectBankActivity;
import com.example.zx.myapplication.biz.sendsms.SendSMSActivity;
import com.example.zx.myapplication.biz.Telephone.TelephoneActivity;
import com.example.zx.myapplication.biz.VerificationCode.VerifyCodeActivity;

/**
 * 主界面
 * Created by ex-zhangxiang on 2016/7/22.
 */
public class MainActivity extends BaseActivity implements MainContract.view{

	public static final String TAG = "MainActivity";

	private Button mBtnSQLite;
	private Button mBtnImageSelector;
	private Button mBtnTelephonoe;
	private Button mBtnSendSMS;
	private Button mBtnFileStore;
	private Button mBtnVerifyCode;
	private Button mBtnSelectBank;

	private MainContract.Presenter mPresenter;

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
		mBtnVerifyCode = (Button) findViewById(R.id.main_verify_code);
		mBtnSelectBank = (Button) findViewById(R.id.main_select_bank);

		new MainPresenter(this,this);
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
		mBtnVerifyCode.setOnClickListener(this);
		mBtnSelectBank.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		switch (view.getId()) {
			case R.id.main_sqlite:
				mPresenter.startNetxtActivity(SQLiteActivity.class);
				break;
			case R.id.main_imageselector:
				mPresenter.startNetxtActivity(ImageSelectorActivity.class);
				break;
			case R.id.main_telephone:
				mPresenter.startNetxtActivity(TelephoneActivity.class);
				break;
			case R.id.main_sendsms:
				mPresenter.startNetxtActivity(SendSMSActivity.class);
				break;
			case R.id.main_filestore:
				mPresenter.startNetxtActivity(FileStoreActivity.class);
				break;
			case R.id.main_verify_code:
				mPresenter.startNetxtActivity(VerifyCodeActivity.class);
				break;
			case R.id.main_select_bank:
				mPresenter.startNetxtActivity(SelectBankActivity.class);
				break;
			default:
				break;
		}
	}

	@Override
	public void startActivity(Class cls) {
		startNextActivity(cls);
	}

	@Override
	public void setPresenter(MainContract.Presenter presenter) {
		mPresenter = presenter;
	}
}
