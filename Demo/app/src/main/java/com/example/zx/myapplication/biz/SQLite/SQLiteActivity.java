package com.example.zx.myapplication.biz.SQLite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;
import com.example.zx.myapplication.db.TestDbHelper;

/**
 * sqlite  测试
 * Created by ex-zhangxiang on 2016/7/26.
 */
public class SQLiteActivity extends BaseActivity implements SQLiteContract.View{

	private Button mBtnCreateDatabase;
	private Button mBtnUpdateDatebase;
	private Button mBtnInsert;
	private Button mBtnUpdate;
	private Button mBtnQuery;
	private Button mBtnDelete;
	private SQLiteContract.Presenter mPresenter;

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
		new SQLitePresenter(this);
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
				mPresenter.creatdb(this);
				break;
			case R.id.sql_update_database:// 更新数据库
				mPresenter.updatedb(this);
				break;
			case R.id.sql_insert:// 插入数据
				mPresenter.insert(this);
				break;
			case R.id.sql_update:// 修改数据
				mPresenter.update(this);
				break;
			case R.id.sql_query:// 查询数据
				mPresenter.query(this);
				break;
			case R.id.sql_delete:// 删除数据
				mPresenter.delete(this);
				break;
			default:
				break;
		}
	}

	@Override
	public void setPresenter(SQLiteContract.Presenter presenter) {
		mPresenter = presenter;
	}
}
