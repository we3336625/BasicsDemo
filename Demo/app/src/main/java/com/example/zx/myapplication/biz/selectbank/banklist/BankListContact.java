package com.example.zx.myapplication.biz.selectbank.banklist;

import android.view.View;
import android.widget.ListView;

import com.example.zx.myapplication.base.BasePresenter;
import com.example.zx.myapplication.base.BaseView;
import com.example.zx.myapplication.data.data.BankCardBean;

import java.util.List;

/**
 * Created by ex-zhangxiang on 2016/8/30.
 */
public interface BankListContact {
	interface view extends BaseView<presenter> {
		void addList(BankCardBean bankCardBean);
	}

	interface presenter extends BasePresenter {
		void queryBank();
	}
}
