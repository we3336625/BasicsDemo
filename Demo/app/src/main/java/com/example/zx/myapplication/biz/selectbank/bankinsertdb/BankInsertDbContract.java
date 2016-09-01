package com.example.zx.myapplication.biz.selectbank.bankinsertdb;

import com.example.zx.myapplication.base.BasePresenter;
import com.example.zx.myapplication.base.BaseView;
import com.example.zx.myapplication.data.data.BankCardBean;

/**
 * Created by ex-zhangxiang on 2016/9/1.
 */
public interface BankInsertDbContract {
	interface view extends BaseView<presenter> {

	}

	interface presenter extends BasePresenter {
		void inseterDB(BankCardBean bean);
	}
}
