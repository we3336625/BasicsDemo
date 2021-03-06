package com.example.zx.myapplication.biz.selectbank;

import android.content.Intent;

import com.example.zx.myapplication.base.BasePresenter;
import com.example.zx.myapplication.base.BaseView;
import com.example.zx.myapplication.data.data.BankCardBean;

/**
 * Created by ex-zhangxiang on 2016/8/30.
 */
public interface SelectBankContract {

	interface view extends BaseView<presenter> {
		void showText(BankCardBean bean);
	}

	interface presenter extends BasePresenter {
		void activityResult(int requestCode, int resultCode, Intent data);
	}
}
