package com.example.zx.myapplication.biz.selectbank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;
import com.example.zx.myapplication.biz.selectbank.bankinsertdb.BankInsertDbActivity;
import com.example.zx.myapplication.biz.selectbank.banklist.BankListActivity;
import com.example.zx.myapplication.data.data.BankCardBean;
import com.example.zx.myapplication.utils.BankCardIconUtil;

/**
 * Created by ex-zhangxiang on 2016/8/30.
 */
public class SelectBankActivity extends BaseActivity implements SelectBankContract.view{

	public static final String BUNDLE = "bundle";
	public static final int FOR_RESULT = 0x01;

	private LinearLayout select_bank;
	private Button btn_insert;

	private ImageView iv_bank_card;
	private TextView tv_bank_name;
	private TextView tv_bank_card_number;

	private SelectBankContract.presenter mPresenter;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_select_bank;
	}

	@Override
	protected void findViews() {
		super.findViews();
		select_bank = (LinearLayout) findViewById(R.id.select_bank);
		btn_insert = (Button) findViewById(R.id.btn_insert);
		iv_bank_card = (ImageView) findViewById(R.id.iv_bank_card);
		tv_bank_name = (TextView) findViewById(R.id.tv_bank_name);
		tv_bank_card_number = (TextView) findViewById(R.id.tv_bank_card_number);

		new SelectBankPresenter(this);
	}

	@Override
	protected void setupListeners() {
		super.setupListeners();
		select_bank.setOnClickListener(this);
		btn_insert.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		switch (view.getId()){
			case R.id.select_bank:
				Intent intent = new Intent(this,BankListActivity.class);
				startActivityForResult(intent, FOR_RESULT);
				animLeftToRight();
				break;
			case R.id.btn_insert:
				startNextActivity(BankInsertDbActivity.class);
				break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		mPresenter.activityResult(requestCode, resultCode, data);
	}

	@Override
	public void showText(BankCardBean bean) {
		BankCardIconUtil.setBankIcon(bean.getBankName(), iv_bank_card);
		tv_bank_name.setText(bean.getBankName());
		tv_bank_card_number.setText(bean.getCardNumber());
	}

	@Override
	public void setPresenter(SelectBankContract.presenter presenter) {
		mPresenter = presenter;
	}
}
