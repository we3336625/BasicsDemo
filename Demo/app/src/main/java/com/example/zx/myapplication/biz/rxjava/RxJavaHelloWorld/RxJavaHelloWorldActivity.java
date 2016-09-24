package com.example.zx.myapplication.biz.rxjava.RxJavaHelloWorld;

import android.view.View;
import android.widget.Button;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;
import com.example.zx.myapplication.utils.LogUtils;

import butterknife.BindView;

public class RxJavaHelloWorldActivity extends BaseActivity implements RxJavaHelloWorldContract.view {

	@BindView(R.id.btn_rxjavahw_hw)
	Button btn_rxjavahw_hw;
	@BindView(R.id.btn_rxjavahw_hw2)
	Button btn_rxjavahw_hw2;
	@BindView(R.id.btn_rxjavahw_hw3)
	Button btn_rxjavahw_hw3;

	private RxJavaHelloWorldContract.presenter mPresenter;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_rx_java_hello_world;
	}

	@Override
	protected void findViews() {
		super.findViews();
		setTitle(R.string.rxjava_helloworld);
		new RxJavaHelloWorldPresenter(this);
	}

	@Override
	protected void setupListeners() {
		super.setupListeners();
		btn_rxjavahw_hw.setOnClickListener(this);
		btn_rxjavahw_hw2.setOnClickListener(this);
		btn_rxjavahw_hw3.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		switch (view.getId()){
			case R.id.btn_rxjavahw_hw:
				mPresenter.rxjavaHelloWorld();
				break;
			case R.id.btn_rxjavahw_hw2:
				mPresenter.rxjavaHelloWorld2();
				break;
			case R.id.btn_rxjavahw_hw3:
				mPresenter.rxjavaHelloWorld3();
				break;
			default:
				break;
		}
	}

	@Override
	public void showLog(String str) {
		LogUtils.i(str);
		tip(str);
	}

	@Override
	public void setPresenter(RxJavaHelloWorldContract.presenter presenter) {
		mPresenter = presenter;
	}
}
