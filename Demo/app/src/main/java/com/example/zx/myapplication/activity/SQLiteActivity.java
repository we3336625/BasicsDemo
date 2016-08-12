package com.example.zx.myapplication.activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.db.TestDbHelper;

/**
 * sqlite  测试
 * Created by ex-zhangxiang on 2016/7/26.
 */
public class SQLiteActivity extends BaseActivity {

	private Button mBtnCreateDatabase;
	private Button mBtnUpdateDatebase;
	private Button mBtnInsert;
	private Button mBtnUpdate;
	private Button mBtnQuery;
	private Button mBtnDelete;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_sqlite;
	}

	@Override
	protected void findViews() {
		super.findViews();
		setTitle(R.string.sql_title);
		mBtnCreateDatabase = (Button) findViewById(R.id.sql_create_database);
		mBtnUpdateDatebase = (Button) findViewById(R.id.sql_update_database);
		mBtnInsert = (Button) findViewById(R.id.sql_insert);
		mBtnUpdate = (Button) findViewById(R.id.sql_update);
		mBtnQuery = (Button) findViewById(R.id.sql_query);
		mBtnDelete = (Button) findViewById(R.id.sql_delete);
	}

	@Override
	protected void setupListeners() {
		super.setupListeners();
		mBtnCreateDatabase.setOnClickListener(this);
		mBtnUpdateDatebase.setOnClickListener(this);
		mBtnInsert.setOnClickListener(this);
		mBtnUpdate.setOnClickListener(this);
		mBtnQuery.setOnClickListener(this);
		mBtnDelete.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		TestDbHelper testDbHelper;
		SQLiteDatabase db;
		switch (view.getId()) {
			case R.id.sql_create_database:// 创建数据库
				testDbHelper = new TestDbHelper(SQLiteActivity.this, "stu_db", null, 1);
				testDbHelper.getReadableDatabase();
				break;
			case R.id.sql_update_database:// 更新数据库
				new TestDbHelper(SQLiteActivity.this, "stu_db", null, 2);
				break;
			case R.id.sql_insert:// 插入数据
				testDbHelper = new TestDbHelper(SQLiteActivity.this, "stu_db", null, 2);
				testDbHelper.SqlInsert(testDbHelper);
				break;
			case R.id.sql_update:// 修改数据
				testDbHelper = new TestDbHelper(SQLiteActivity.this, "stu_db", null, 2);
				db = testDbHelper.getWritableDatabase();
				ContentValues contentValues = new ContentValues();
				contentValues.put("sage", "23");
				//where 子句 "?"是占位符号，对应后面的"1",
				String whereClause="id=?";
				String [] whereArgs = {String.valueOf(1)};
				//参数1 是要更新的表名
				//参数2 是一个ContentValeus对象
				//参数3 是where子句
				db.update("stu_table", contentValues, whereClause, whereArgs);

				break;
			case R.id.sql_query:// 查询数据
				testDbHelper = new TestDbHelper(SQLiteActivity.this, "stu_db", null, 2);
				db = testDbHelper.getReadableDatabase();
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
				break;
			case R.id.sql_delete:// 删除数据
				testDbHelper = new TestDbHelper(SQLiteActivity.this, "stu_db", null, 2);
				db = testDbHelper.getWritableDatabase();
				String whereClauses = "id=?";
				String [] whereArg = {String.valueOf(1)};
				//调用delete方法，删除数据
				db.delete("stu_table", whereClauses, whereArg);
				break;
			default:
				break;
		}
	}
}
