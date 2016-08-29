package com.example.zx.myapplication.biz.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.zx.myapplication.db.TestDbHelper;

/**
 * Created by ex-zhangxiang on 2016/8/26.
 */
public class SQLitePresenter implements SQLiteContract.Presenter {

	public SQLitePresenter(SQLiteContract.View view){
		view.setPresenter(this);
	}

	@Override
	public void creatdb(Context context) {
		TestDbHelper testDbHelper = new TestDbHelper(context, "stu_db", null, 1);
		testDbHelper.getReadableDatabase();
	}

	@Override
	public void updatedb(Context context) {
		new TestDbHelper(context, "stu_db", null, 2);
	}

	@Override
	public void insert(Context context) {
		TestDbHelper testDbHelper = new TestDbHelper(context, "stu_db", null, 2);
		testDbHelper.SqlInsert(testDbHelper);
	}

	@Override
	public void update(Context context) {
		TestDbHelper testDbHelper = new TestDbHelper(context, "stu_db", null, 2);
		SQLiteDatabase db  = testDbHelper.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("sage", "23");
		//where 子句 "?"是占位符号，对应后面的"1",
		String whereClause="id=?";
		String [] whereArgs = {String.valueOf(1)};
		//参数1 是要更新的表名
		//参数2 是一个ContentValeus对象
		//参数3 是where子句
		db.update("stu_table", contentValues, whereClause, whereArgs);
	}

	@Override
	public void query(Context context) {
		TestDbHelper testDbHelper = new TestDbHelper(context, "stu_db", null, 2);
		SQLiteDatabase db = testDbHelper.getReadableDatabase();
		//参数1：表名
		//参数2：要想显示的列
		//参数3：where子句
		//参数4：where子句对应的条件值
		//参数5：分组方式
		//参数6：having条件
		//参数7：排序方式
		Cursor cursor = db.query("stu_table", new String[]{"id", "sname", "sage", "ssex"}, "id=?", new String[]{"1"}, null, null, null);
		while (cursor.moveToNext()) {
			String name = cursor.getString(cursor.getColumnIndex("sname"));
			String age = cursor.getString(cursor.getColumnIndex("sage"));
			String sex = cursor.getString(cursor.getColumnIndex("ssex"));
			System.out.println("query------->" + "姓名：" + name + " " + "年龄：" + age + " " + "性别：" + sex);
		}
		//关闭数据库
		db.close();
	}

	@Override
	public void delete(Context context) {
		TestDbHelper testDbHelper = new TestDbHelper(context, "stu_db", null, 2);
		SQLiteDatabase db = testDbHelper.getWritableDatabase();
		String whereClauses = "id=?";
		String [] whereArg = {String.valueOf(1)};
		//调用delete方法，删除数据
		db.delete("stu_table", whereClauses, whereArg);
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
