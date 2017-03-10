package com.example.zx.myapplication.biz.main;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;
import com.example.zx.myapplication.biz.convenionbanner.ConvenientBannerActivity;
import com.example.zx.myapplication.biz.diary.DiaryActivity;
import com.example.zx.myapplication.biz.download.DownLoadActivity;
import com.example.zx.myapplication.biz.eventbus.eventbusfirst.EventBusFirstActivity;
import com.example.zx.myapplication.biz.filestore.FileStoreActivity;
import com.example.zx.myapplication.biz.SQLite.SQLiteActivity;
import com.example.zx.myapplication.biz.glide.GlideActivity;
import com.example.zx.myapplication.biz.retrofit.RetrofitActivity;
import com.example.zx.myapplication.biz.rxjava.RxJavaActivity;
import com.example.zx.myapplication.biz.selectbank.SelectBankActivity;
import com.example.zx.myapplication.biz.sendsms.SendSMSActivity;
import com.example.zx.myapplication.biz.Telephone.TelephoneActivity;
import com.example.zx.myapplication.biz.VerificationCode.VerifyCodeActivity;
import com.example.zx.myapplication.biz.xrecyclerview.XRecyclerViewActivity;
import com.example.zx.myapplication.biz.custom_view.CustomViewActivity;

import butterknife.OnClick;

/**
 * 主界面
 * Created by ex-zhangxiang on 2016/7/22.
 */
public class MainActivity extends BaseActivity implements MainContract.view {

	public static final String TAG = "MainActivity";

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
	}

	@OnClick({
			R.id.main_sqlite,
			R.id.main_telephone,
			R.id.main_sendsms,
			R.id.main_filestore,
			R.id.main_verify_code,
			R.id.main_select_bank,
			R.id.main_diary,
			R.id.main_eventbus,
			R.id.main_rxjava,
			R.id.main_convenientbanner,
			R.id.main_glide,
			R.id.main_download,
			R.id.main_xrecyclerview,
			R.id.main_custom_view,
			R.id.main_retrofit
	})
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
			case R.id.main_rxjava:
				mPresenter.startNetxtActivity(RxJavaActivity.class);
				break;
			case R.id.main_convenientbanner:
				mPresenter.startNetxtActivity(ConvenientBannerActivity.class);
				break;
			case R.id.main_glide:
				mPresenter.startNetxtActivity(GlideActivity.class);
				break;
			case R.id.main_download:
				mPresenter.startNetxtActivity(DownLoadActivity.class);
				break;
			case R.id.main_xrecyclerview:
				mPresenter.startNetxtActivity(XRecyclerViewActivity.class);
				break;
			case R.id.main_custom_view:
				mPresenter.startNetxtActivity(CustomViewActivity.class);
				break;
			case R.id.main_retrofit:
				mPresenter.startNetxtActivity(RetrofitActivity.class);
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
