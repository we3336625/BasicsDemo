package com.example.zx.myapplication.biz.selectbank.banklist;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.zx.myapplication.data.data.BankCardBean;
import com.example.zx.myapplication.db.BankDbHelper;

/**
 * Created by ex-zhangxiang on 2016/8/30.
 */
public class BankListPresenter implements BankListContact.presenter {

	Context mContext;
	BankListContact.view view;

	public BankListPresenter(Context context, BankListContact.view view) {
		this.mContext = context;
		this.view = view;
		view.setPresenter(this);
	}

	@Override
	public void queryBank() {
		BankDbHelper bankDbHelper = new BankDbHelper(mContext, "bank_table", null, 1);
		SQLiteDatabase db = bankDbHelper.getReadableDatabase();
		Cursor cursor = db.query("bank_table", new String[]{"id", "bankname", "banknumber"}, "id=?", new String[]{"1"}, null, null, null);
		BankCardBean bankCardBean;
		while (cursor.moveToNext()) {
			String bankname = cursor.getString(cursor.getColumnIndex("bankname"));
			String banknumber = cursor.getString(cursor.getColumnIndex("banknumber"));
			bankCardBean = new BankCardBean();
			bankCardBean.setBankName(bankname);
			bankCardBean.setCardNumber(banknumber);
			view.addList(bankCardBean);
			System.out.println("query------->" + "bankname：" + bankname + " " + "banknumber：" + banknumber);
		}
		//关闭数据库
		db.close();
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
