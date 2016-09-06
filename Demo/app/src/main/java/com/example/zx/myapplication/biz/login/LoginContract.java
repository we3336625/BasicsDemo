package com.example.zx.myapplication.biz.login;

import com.example.zx.myapplication.base.BasePresenter;
import com.example.zx.myapplication.base.BaseView;

/**
 * Created by ex-zhangxiang on 2016/9/5.
 */
public interface LoginContract {
	interface view extends BaseView<presenter>{
		void success();

		void showEmpty();

		void showUserError();

		void showPwdError();

		void toRegister();
	}

	interface presenter extends BasePresenter{
		void login(String user, String pwd);

		void register();
	}
}
