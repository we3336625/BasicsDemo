package com.example.zx.myapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ex-zhangxiang on 2016/7/26.
 */
public class TestDbHelper extends SQLiteOpenHelper {

	public static final String TAG = "TestDbHelper";

	public TestDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	// 第一次创建数据库时调用
	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase) {
		String sql = "create table stu_table(id int,sname varchar(20),sage int,ssex varchar(10))";
		Log.i(TAG, "create Database  ------------------------->");
		sqLiteDatabase.execSQL(sql);
	}

	// 更新数据库时执行
	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
		Log.i(TAG, "update Datebase  ------------------------->");
	}

	public void SqlInsert(TestDbHelper testDbHelper, String name, int age, String sex) {
		SQLiteDatabase db = testDbHelper.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("id", 1);
		cv.put("sname", name);
		cv.put("sage", age);
		cv.put("ssex", sex);
		db.insert("stu_table", null, cv);
		db.close();
	}
}
