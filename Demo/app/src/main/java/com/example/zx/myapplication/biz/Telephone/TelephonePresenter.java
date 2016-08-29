package com.example.zx.myapplication.biz.Telephone;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by ex-zhangxiang on 2016/8/26.
 */
public class TelephonePresenter implements TelephoneContract.Presenter {
	private TelephoneContract.View view;

	public TelephonePresenter(TelephoneContract.View view){
		this.view = view;
		view.setPresenter(this);
	}

	@Override
	public void startToActivity(String number) {
		if (number != null && number.length() > 0) {
			Uri uri = Uri.parse("tel:" + number);
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_CALL);
			intent.setData(uri);
			view.toActivity(intent);
		} else {
			view.showErrorTip();
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
