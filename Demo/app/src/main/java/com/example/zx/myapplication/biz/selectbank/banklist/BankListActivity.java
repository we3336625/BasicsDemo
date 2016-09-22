package com.example.zx.myapplication.biz.selectbank.banklist;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;
import com.example.zx.myapplication.biz.selectbank.SelectBankActivity;
import com.example.zx.myapplication.data.data.BankCardBean;
import com.example.zx.myapplication.db.BankDbHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 选择银行卡
 * Created by ex-zhangxiang on 2016/8/30.
 */
public class BankListActivity extends BaseActivity implements BankListContact.view {

	@BindView(R.id.lv_banklist)
	ListView mListView;
	@BindView(R.id.btn_banklist)
	Button btn_banklist;

	private List<BankCardBean> mList = new ArrayList<BankCardBean>();
	private BankListAdapter adapter;
	private BankCardBean bean = new BankCardBean();

	private BankListContact.presenter mPresenter;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_banklist;
	}

	@Override
	protected void findViews() {
		super.findViews();
		setTitle(R.string.selectbank);
		new BankListPresenter(this, this);
	}

	@Override
	protected void setupListeners() {
		super.setupListeners();
		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
				Log.i("BankListActivity", "position----------->" + position);
				for (int i = 0; i < mListView.getChildCount(); i++) {
					View child = mListView.getChildAt(i);
					child.findViewById(R.id.iv_bank_select).setVisibility(View.INVISIBLE);
				}
				view.findViewById(R.id.iv_bank_select).setVisibility(View.VISIBLE);

				bean.setBankName(mList.get(position).getBankName());
				bean.setCardNumber(mList.get(position).getCardNumber());

			}
		});

		btn_banklist.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		if (view.getId() == R.id.btn_banklist) {
			Intent intent = new Intent();
			Bundle bundle = new Bundle();
			bundle.putSerializable(SelectBankActivity.BUNDLE, bean);
			intent.putExtras(bundle);
			setResult(RESULT_OK, intent);
			closeActivity();
		}
	}

	@Override
	protected void initData() {
		super.initData();

		mPresenter.queryBank();

		adapter = new BankListAdapter(this, mList);
		mListView.setAdapter(adapter);
	}

	@Override
	public void addList(BankCardBean bankCardBean) {
		mList.add(bankCardBean);
	}

	@Override
	public void setPresenter(BankListContact.presenter presenter) {
		mPresenter = presenter;
	}
}
