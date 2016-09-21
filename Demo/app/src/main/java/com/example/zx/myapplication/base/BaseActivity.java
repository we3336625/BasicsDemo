package com.example.zx.myapplication.base;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zx.myapplication.R;

/**
 * Created by ex-zhangxiang on 2016/7/21.
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

	/**
	 * 标题栏标题
	 */
	private TextView mTitleTv;

	/**
	 * 标题栏返回键
	 */
	private TextView mBackTv;

	private Toast mToast;

	protected Context mContext;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		if (getSupportActionBar() != null){
			getSupportActionBar().hide();
		}
		setContentView(getLayoutId());
		initResouce();

		findViews();
		setupListeners();
		initData();
	}

	/**
	 * 获取布局id
	 * @return
	 */
	protected abstract int getLayoutId();

	/**
	 * 初始化公共资源
	 */
	private void initResouce(){
		mContext = this;
	};

	/**
	 * 获取页面控件
	 */
	protected void findViews() {
		mTitleTv = (TextView) findViewById(R.id.title);
		mBackTv = (TextView) findViewById(R.id.back);
	}

	/**
	 * 为界面控件设置监听
	 */
	protected void setupListeners() {
		if (mBackTv != null) {
			mBackTv.setOnClickListener(this);
		}
	}

	/**
	 * 初始化数据
	 */
	protected void initData() {
	}

	/**
	 * 设置页面标题
	 *
	 * @param resId 标题资源id
	 */
	@Override
	public void setTitle(int resId) {
		setTitle(getText(resId));
	}

	/**
	 * 设置页面标题
	 *
	 * @param pageTitle 标题
	 */
	@Override
	public void setTitle(
			CharSequence pageTitle
	) {
		if (mTitleTv == null) {
			return;
		}
		// 页面标题
		if (TextUtils.isEmpty(pageTitle)) {
			mTitleTv.setText(R.string.app_name);
		} else {
			mTitleTv.setText(pageTitle);
		}
	}

	@Override
	public void onClick(View view) {
		if (R.id.back == view.getId()) {
			onBackPressed();
		}
	}

	/**
	 * 系统返回键和标题栏返回键处理事件
	 */
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		closeActivity();
	}

	/**
	 * 为子类设定一个公共的结束Activity的方法
	 */
	public void closeActivity() {
		System.gc();
		finish();
		animRightToLeft();
	}

	/**
	 * 当前Activity退出时的动画
	 */
	protected void animRightToLeft() {
		try {
			overridePendingTransition(R.anim.push_right_in2, R.anim.push_right_to2);
		} catch (Exception e) {
		}
	}

	/**
	 * 当前Activity进入时的动画
	 */
	protected void animLeftToRight() {
		try {
			overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
		} catch (Exception e) {
		}
	}

	/**
	 * 打开下一个activity
	 */
	public void startNextActivity(Class<? extends BaseActivity> activity) {
		Intent intent = new Intent(mContext, activity);
		intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		startActivity(intent);
		animLeftToRight();
	}

	/**
	 * 打开下一个activity,自带intent
	 */
	public void startNextActivity(Class<? extends BaseActivity> activity, Intent intent) {
		if (intent == null) return;
		intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		intent.setClass(mContext, activity);
		startActivity(intent);
		animLeftToRight();
	}

	/**
	 * 打开下一个activity,自带intent
	 */
	public void startNextActivity(Class<? extends BaseActivity> activity, Intent intent, int requestCode) {
		if (intent == null) return;
		intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		intent.setClass(mContext, activity);
		startActivityForResult(intent, requestCode);
		animLeftToRight();
	}

	/**
	 * 通过action 访问Activity
	 *
	 * @param intent
	 */
	public void startNextActivity(Intent intent) {
		if (intent == null) return;
		startActivity(intent);
		animLeftToRight();
	}

	public void implicitStartActivity(String action) {
		try {
			Intent intent = new Intent();
			intent.setClassName(getPackageName(), action);
			startActivity(intent);
			animLeftToRight();
		} catch (ActivityNotFoundException e) {
			tip(e + "");
		}
	}

	/**
	 * 自定义吐司
	 *
	 * @param msg
	 */
	public void tip(String msg) {
		tip(this, msg, Toast.LENGTH_LONG);
	}

	/**
	 * 自定义吐司
	 */
	public void tip(final int resId) {
		tip(this, this.getString(resId), Toast.LENGTH_LONG);
	}

	/**
	 * 自定义Toast
	 *
	 * @param duration
	 */
	private void tip(final Context context, final String msg, final int duration) {
		this.runOnUiThread(new Runnable() {

			@Override
			public void run() {
				TextView message;
				if (mToast == null) {
					mToast = new Toast(context);
					View view = LayoutInflater.from(context).inflate(R.layout.mytoast, null);
					message = (TextView) view.findViewById(R.id.toast_tip);
					message.setText(msg);
					mToast.setDuration(duration);
					mToast.setView(view);
				} else {
					View layout = mToast.getView();
					message = (TextView) layout.findViewById(R.id.toast_tip);
					message.setText(msg);
				}
				// 距离顶部100dp
				// toast.setGravity(Gravity.CENTER, 0, -(Sys.getScreenHeight(context) / 2 - Sys.Dp2Px(context, 100)));
				mToast.setGravity(Gravity.CENTER, 0, 0);
				mToast.show();
			}
		});
	}

	/**
	 * 取消提示信息
	 */
	protected void dismissTip() {
		if (mToast != null) {
			mToast.cancel();
		}
	}
}
