package com.example.zx.myapplication.biz.selectbank;

import android.view.View;
import android.widget.LinearLayout;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;
import com.example.zx.myapplication.biz.selectbank.banklist.BankListActivity;

/**
 * Created by ex-zhangxiang on 2016/8/30.
 */
public class SelectBankActivity extends BaseActivity{

	private LinearLayout select_bank;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_select_bank;
	}

	@Override
	protected void findViews() {
		super.findViews();
		select_bank = (LinearLayout) findViewById(R.id.select_bank);
	}

	@Override
	protected void setupListeners() {
		super.setupListeners();
		select_bank.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		switch (view.getId()){
			case R.id.select_bank:
				startNextActivity(BankListActivity.class);
				break;
		}
	}
}
