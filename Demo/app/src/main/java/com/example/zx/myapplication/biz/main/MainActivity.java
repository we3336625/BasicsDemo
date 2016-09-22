package com.example.zx.myapplication.biz.main;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;
import com.example.zx.myapplication.biz.diary.DiaryActivity;
import com.example.zx.myapplication.biz.eventbus.eventbusfirst.EventBusFirstActivity;
import com.example.zx.myapplication.biz.filestore.FileStoreActivity;
import com.example.zx.myapplication.biz.SQLite.SQLiteActivity;
import com.example.zx.myapplication.biz.selectbank.SelectBankActivity;
import com.example.zx.myapplication.biz.sendsms.SendSMSActivity;
import com.example.zx.myapplication.biz.Telephone.TelephoneActivity;
import com.example.zx.myapplication.biz.VerificationCode.VerifyCodeActivity;

import butterknife.BindView;

/**
 * 主界面
 * Created by ex-zhangxiang on 2016/7/22.
 */
public class MainActivity extends BaseActivity implements MainContract.view {

	public static final String TAG = "MainActivity";

	@BindView(R.id.main_sqlite)
	Button mBtnSQLite;
	@BindView(R.id.main_telephone)
	Button mBtnTelephonoe;
	@BindView(R.id.main_sendsms)
	Button mBtnSendSMS;
	@BindView(R.id.main_filestore)
	Button mBtnFileStore;
	@BindView(R.id.main_verify_code)
	Button mBtnVerifyCode;
	@BindView(R.id.main_select_bank)
	Button mBtnSelectBank;
	@BindView(R.id.main_diary)
	Button mBtnDiary;
	@BindView(R.id.main_eventbus)
	Button mBtnEventBus;

	private long PRESS_TIME;//双击退出

	private MainContract.Presenter mPresenter;

	@Override
	protected void findViews() {
		super.findViews();
		setTitle(R.string.main);
		initTitleButton();

		new MainPresenter(this, this);
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
		mBtnDiary.setOnClickListener(this);
		mBtnEventBus.setOnClickListener(this);
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
			case R.id.main_diary:
				mPresenter.startNetxtActivity(DiaryActivity.class);
				break;
			case R.id.main_eventbus:
				mPresenter.startNetxtActivity(EventBusFirstActivity.class);
				break;
			default:
				break;
		}
	}

	/**
	 * 重写onKeyDown，双击退出
	 *
	 * @param keyCode
	 * @param event
	 * @return
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (System.currentTimeMillis() - PRESS_TIME > 2000) {
			tip("再按一次退出");
		} else if (System.currentTimeMillis() - PRESS_TIME <= 2000) {
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
