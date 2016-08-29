package com.example.zx.myapplication.biz.sendsms;

import android.widget.EditText;

import com.example.zx.myapplication.base.BasePresenter;
import com.example.zx.myapplication.base.BaseView;

/**
 * Created by ex-zhangxiang on 2016/8/29.
 */
public interface SendSMSContract {

	interface view extends BaseView<presenter>{
		void showNull();

		void showWrong();

		void sendSMS(String phone, String content);
	}

	interface presenter extends BasePresenter{
		void send(String phone, String content);
	}

}
