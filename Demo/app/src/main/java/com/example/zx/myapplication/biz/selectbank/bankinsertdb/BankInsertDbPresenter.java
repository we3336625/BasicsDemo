package com.example.zx.myapplication.biz.selectbank.bankinsertdb;

import android.content.Context;

import com.example.zx.myapplication.data.data.BankCardBean;
import com.example.zx.myapplication.db.BankDbHelper;

/**
 * Created by ex-zhangxiang on 2016/9/1.
 */
public class BankInsertDbPresenter implements BankInsertDbContract.presenter {

	Context context;
	BankInsertDbContract.view view;

	public BankInsertDbPresenter(Context context, BankInsertDbContract.view view) {
		this.context = context;
		this.view = view;
		view.setPresenter(this);
	}

	@Override
	public void inseterDB(BankCardBean bean) {
		BankDbHelper bankDbHelper = new BankDbHelper(context, "bank_table", null, 1);
		bankDbHelper.SqlInsert(bankDbHelper, bean);
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
