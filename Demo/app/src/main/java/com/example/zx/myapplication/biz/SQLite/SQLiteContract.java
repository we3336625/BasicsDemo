package com.example.zx.myapplication.biz.SQLite;

import android.content.Context;

import com.example.zx.myapplication.base.BasePresenter;
import com.example.zx.myapplication.base.BaseView;

/**
 * Created by ex-zhangxiang on 2016/8/26.
 */
public interface SQLiteContract {

	interface View extends BaseView<Presenter>{

	}

	interface Presenter extends BasePresenter{
		/**
		 * 创建数据库
		 * @param context
		 */
		void creatdb(Context context);

		/**
		 * 更新数据库
		 * @param context
		 */
		void updatedb(Context context);

		/**
		 * 插入数据
		 * @param context
		 */
		void insert(Context context);

		/**
		 * 修改数据
		 * @param context
		 */
		void update(Context context);

		/**
		 * 查询数据
		 * @param context
		 */
		void query(Context context);

		/**
		 * 删除数据
		 * @param context
		 */
		void delete(Context context);
	}
}
