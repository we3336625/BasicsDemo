package com.example.zx.myapplication.biz.login.register;

import com.example.zx.myapplication.base.BasePresenter;
import com.example.zx.myapplication.base.BaseView;

/**
 * Created by ex-zhangxiang on 2016/9/5.
 */
public interface RegisterContract {
	interface view extends BaseView<presenter> {
		void showEmpty();

		void showError();

		void toLogin();
	}

	interface presenter extends BasePresenter {
		void sure(String user, String pwd1, String pwd2);
	}
}
