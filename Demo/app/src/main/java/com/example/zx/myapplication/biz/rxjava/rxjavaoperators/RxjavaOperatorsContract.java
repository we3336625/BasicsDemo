package com.example.zx.myapplication.biz.rxjava.rxjavaoperators;

import com.example.zx.myapplication.base.BasePresenter;
import com.example.zx.myapplication.base.BaseView;

/**
 * Created by ex-zhangxiang on 2016/9/23.
 */

public interface RxjavaOperatorsContract {

	interface view extends BaseView<presenter>{
		void showtip(String s);
	}

	interface presenter extends BasePresenter{
		void rxjavaOperators();

		void rxjavaOperators2();

		void rxjavaOperators3();

		void rxjavaOperators4();

		void rxjavaFlatMap();

		void rxjavaFlatMap2();

		void rxjavaFlatMap3();

		void rxjavaFlatMap4();

		void rxjavaFlatMap5();

		void rxjavaFlatMap6();
	}

}
