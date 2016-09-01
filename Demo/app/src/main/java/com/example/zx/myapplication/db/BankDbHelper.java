package com.example.zx.myapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.zx.myapplication.data.data.BankCardBean;

/**
 * Created by ex-zhangxiang on 2016/8/31.
 */
public class BankDbHelper extends SQLiteOpenHelper {

	public static final String TAG = "BankDbHelper";

	public BankDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table bank_table(id int,bankname varchar(20),banknumber varchar(20))";
		db.execSQL(sql);
		Log.i(TAG, "create Database  ------------------------->");
	}

	/**
	 * 数据库更新
	 * @param db
	 * @param oldVersion
	 * @param newVersion
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

	public void SqlInsert(BankDbHelper bankDbHelper, BankCardBean bean) {
		SQLiteDatabase db = bankDbHelper.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("id", 1);
		cv.put("bankname", bean.getBankName());
		cv.put("banknumber", bean.getCardNumber());
		db.insert("bank_table", null, cv);
		db.close();
	}

}
