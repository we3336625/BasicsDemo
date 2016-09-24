package com.example.zx.myapplication.biz.rxjava.RxJavaHelloWorld;

import com.example.zx.myapplication.base.BasePresenter;
import com.example.zx.myapplication.base.BaseView;

/**
 * Created by ex-zhangxiang on 2016/9/23.
 */

public interface RxJavaHelloWorldContract {
	interface view extends BaseView<presenter>{
		void showLog(String str);
	}

	interface presenter extends BasePresenter{
		void rxjavaHelloWorld();

		void rxjavaHelloWorld2();

		void rxjavaHelloWorld3();
	}
}
