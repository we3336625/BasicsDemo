package com.example.zx.myapplication.biz.main;

import android.content.Context;

import com.example.zx.myapplication.base.BasePresenter;
import com.example.zx.myapplication.base.BaseView;

/**
 * Created by ex-zhangxiang on 2016/8/26.
 */
public interface MainContract {

	interface view extends BaseView<Presenter>{
		void startActivity(Class cls);
	}


	interface Presenter extends BasePresenter{
		/**
		 * 跳转到下一个activity
		 * @param cls
		 */
		void startNetxtActivity(Class cls);
	}

}
