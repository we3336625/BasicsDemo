package com.example.zx.myapplication.biz.selectbank.banklist;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;
import com.example.zx.myapplication.data.data.BankCardBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ex-zhangxiang on 2016/8/30.
 */
public class BankListActivity extends BaseActivity {

	private ListView mListView;
	private List<BankCardBean> mList = new ArrayList<BankCardBean>();
	private BankListAdapter adapter;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_banklist;
	}

	@Override
	protected void findViews() {
		super.findViews();
		mListView = (ListView) findViewById(R.id.lv_banklist);
		setTitle("选择银行卡");
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
			}
		});
	}

	@Override
	protected void initData() {
		super.initData();
		BankCardBean bankCardBean = new BankCardBean();
		bankCardBean.setBankName("中国银行");
		bankCardBean.setCardNumber("1111");
		mList.add(bankCardBean);

		bankCardBean = new BankCardBean();
		bankCardBean.setBankName("农业银行");
		bankCardBean.setCardNumber("2222");
		mList.add(bankCardBean);

		bankCardBean = new BankCardBean();
		bankCardBean.setBankName("建设银行");
		bankCardBean.setCardNumber("3333");
		mList.add(bankCardBean);

		bankCardBean = new BankCardBean();
		bankCardBean.setBankName("招商银行");
		bankCardBean.setCardNumber("4444");
		mList.add(bankCardBean);

		bankCardBean = new BankCardBean();
		bankCardBean.setBankName("浙商银行");
		bankCardBean.setCardNumber("5555");
		mList.add(bankCardBean);

		bankCardBean = new BankCardBean();
		bankCardBean.setBankName("工商银行");
		bankCardBean.setCardNumber("6666");
		mList.add(bankCardBean);

		bankCardBean = new BankCardBean();
		bankCardBean.setBankName("人民银行");
		bankCardBean.setCardNumber("7777");
		mList.add(bankCardBean);

		adapter = new BankListAdapter(this, mList);
		mListView.setAdapter(adapter);
	}
}
