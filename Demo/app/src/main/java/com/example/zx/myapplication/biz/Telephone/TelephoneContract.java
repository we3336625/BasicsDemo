package com.example.zx.myapplication.biz.Telephone;

import android.content.Intent;

import com.example.zx.myapplication.base.BasePresenter;
import com.example.zx.myapplication.base.BaseView;

/**
 * Created by ex-zhangxiang on 2016/8/26.
 */
public interface TelephoneContract {

	interface View extends BaseView<Presenter>{
		void showErrorTip();

		void toActivity(Intent intent);
	}

	interface Presenter extends BasePresenter{
		/**
		 * 跳转到打电话页面
		 * @param number
		 */
		void startToActivity(String number);
	}
}
