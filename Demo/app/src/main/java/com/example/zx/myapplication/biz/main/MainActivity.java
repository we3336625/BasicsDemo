package com.example.zx.myapplication.biz.main;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;
import com.example.zx.myapplication.biz.filestore.FileStoreActivity;
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
	private Button mBtnTelephonoe;
	private Button mBtnSendSMS;
	private Button mBtnFileStore;
	private Button mBtnVerifyCode;
	private Button mBtnSelectBank;
	private Button mBtnDiary;

	private MainContract.Presenter mPresenter;

	@Override
	protected void findViews() {
		super.findViews();
		setTitle(R.string.main);
		initTitleButton();
		mBtnSQLite = (Button) findViewById(R.id.main_sqlite);
		mBtnTelephonoe = (Button) findViewById(R.id.main_telephone);
		mBtnSendSMS = (Button) findViewById(R.id.main_sendsms);
		mBtnFileStore = (Button) findViewById(R.id.main_filestore);
		mBtnVerifyCode = (Button) findViewById(R.id.main_verify_code);
		mBtnSelectBank = (Button) findViewById(R.id.main_select_bank);
		mBtnDiary = (Button) findViewById(R.id.main_diary);

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

	private long PRESS_TIME;

	/**
	 * 重写onKeyDown，双击退出
	 * @param keyCode
	 * @param event
	 * @return
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (System.currentTimeMillis() - PRESS_TIME > 2000){
			tip("再按一次退出");
		} else if (System.currentTimeMillis() - PRESS_TIME <= 2000){
			closeActivity();
		}
		PRESS_TIME = System.currentTimeMillis();
		return true;
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
