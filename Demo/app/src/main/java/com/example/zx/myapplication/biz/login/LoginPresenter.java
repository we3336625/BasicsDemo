package com.example.zx.myapplication.biz.login;

import android.content.Context;
import android.text.TextUtils;

import com.example.zx.myapplication.utils.SPUtils;

/**
 * Created by ex-zhangxiang on 2016/9/5.
 */
public class LoginPresenter implements LoginContract.presenter {

	private Context mContext;
	private LoginContract.view view;

	public LoginPresenter(Context context, LoginContract.view view){
		this.mContext = context;
		this.view = view;
		view.setPresenter(this);
	}

	@Override
	public void login(String user, String pwd) {
		String spUser = (String) SPUtils.get(mContext, LoginActivity.LOGINUSER, "");
		String spPwd = (String) SPUtils.get(mContext, LoginActivity.LOGINPWD, "");
		if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pwd)){
			view.showEmpty();
		} else if (!spUser.equals(user)){
			view.showUserError();
		} else if (!spPwd.equals(pwd)){
			view.showPwdError();
		} else {
			view.success();
		}
	}

	@Override
	public void register() {
		view.toRegister();
	}

	@Override
	public void islogin() {
		if (SPUtils.get(mContext, LoginActivity.ISLOGIN, "").equals(LoginActivity.ISLOGIN)) {
			view.success();
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
