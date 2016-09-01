package com.example.zx.myapplication.biz.selectbank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.zx.myapplication.data.data.BankCardBean;
import com.example.zx.myapplication.utils.BankCardIconUtil;

/**
 * Created by ex-zhangxiang on 2016/8/30.
 */
public class SelectBankPresenter implements SelectBankContract.presenter {

	SelectBankContract.view view;

	public SelectBankPresenter(SelectBankContract.view view){
		this.view = view;
		view.setPresenter(this);
	}

	@Override
	public void activityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == Activity.RESULT_OK){
			if (requestCode == SelectBankActivity.FOR_RESULT){
				Bundle bundle = data.getExtras();
				BankCardBean bean = (BankCardBean) bundle.get(SelectBankActivity.BUNDLE);
				if (bean.getBankName() != null) {
					view.showText(bean);
				}
			}
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
