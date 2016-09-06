package com.example.zx.myapplication.biz.login.register;

import android.content.Context;
import android.text.TextUtils;

import com.example.zx.myapplication.biz.login.LoginActivity;
import com.example.zx.myapplication.utils.SPUtils;

/**
 * Created by ex-zhangxiang on 2016/9/5.
 */
public class RegisterPresenter implements RegisterContract.presenter {

	private RegisterContract.view view;
	private Context mContext;

	public RegisterPresenter(Context context, RegisterContract.view view) {
		this.mContext = context;
		this.view = view;
		view.setPresenter(this);
	}

	@Override
	public void sure(String user, String pwd1, String pwd2) {
		if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pwd1) || TextUtils.isEmpty(pwd2)) {
			view.showEmpty();
		} else if (!pwd1.equals(pwd2)) {
			view.showError();
		} else {
			SPUtils.put(mContext, LoginActivity.LOGINUSER, user);
			SPUtils.put(mContext, LoginActivity.LOGINPWD, pwd1);
			view.toLogin();
		}
	}

	@Override
	public void start() {

	}

	@Override
	public void subscribe() {

	}

	@Override
	public void unsubscribe() {

	}
}
