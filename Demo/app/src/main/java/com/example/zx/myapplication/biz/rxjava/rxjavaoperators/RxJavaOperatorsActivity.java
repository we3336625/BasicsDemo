package com.example.zx.myapplication.biz.rxjava.rxjavaoperators;

import android.view.View;
import android.widget.Button;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;
import com.example.zx.myapplication.utils.LogUtils;

import butterknife.BindView;

public class RxJavaOperatorsActivity extends BaseActivity implements RxjavaOperatorsContract.view{

	@BindView(R.id.btn_rxjava_op)
	Button btn_rxjava_op;
	@BindView(R.id.btn_rxjava_op2)
	Button btn_rxjava_op2;
	@BindView(R.id.btn_rxjava_op3)
	Button btn_rxjava_op3;
	@BindView(R.id.btn_rxjava_op4)
	Button btn_rxjava_op4;
	@BindView(R.id.btn_rxjava_flatmap)
	Button btn_rxjava_flatmap;
	@BindView(R.id.btn_rxjava_flatmap2)
	Button btn_rxjava_flatmap2;
	@BindView(R.id.btn_rxjava_flatmap3)
	Button btn_rxjava_flatmap3;
	@BindView(R.id.btn_rxjava_flatmap4)
	Button btn_rxjava_flatmap4;
	@BindView(R.id.btn_rxjava_flatmap5)
	Button btn_rxjava_flatmap5;
	@BindView(R.id.btn_rxjava_flatmap6)
	Button btn_rxjava_flatmap6;

	private RxjavaOperatorsContract.presenter mPresenter;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_rx_java_operators;
	}

	@Override
	protected void findViews() {
		super.findViews();
		setTitle(R.string.rxjava_operators);
		new RxJavaOperatorsPresenter(this);
	}

	@Override
	protected void setupListeners() {
		super.setupListeners();
		btn_rxjava_op.setOnClickListener(this);
		btn_rxjava_op2.setOnClickListener(this);
		btn_rxjava_op3.setOnClickListener(this);
		btn_rxjava_op4.setOnClickListener(this);
		btn_rxjava_flatmap.setOnClickListener(this);
		btn_rxjava_flatmap2.setOnClickListener(this);
		btn_rxjava_flatmap3.setOnClickListener(this);
		btn_rxjava_flatmap4.setOnClickListener(this);
		btn_rxjava_flatmap5.setOnClickListener(this);
		btn_rxjava_flatmap6.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		switch (view.getId()){
			case R.id.btn_rxjava_op:
				mPresenter.rxjavaOperators();
				break;
			case R.id.btn_rxjava_op2:
				mPresenter.rxjavaOperators2();
				break;
			case R.id.btn_rxjava_op3:
				mPresenter.rxjavaOperators3();
				break;
			case R.id.btn_rxjava_op4:
				mPresenter.rxjavaOperators4();
				break;
			case R.id.btn_rxjava_flatmap:
				mPresenter.rxjavaFlatMap();
				break;
			case R.id.btn_rxjava_flatmap2:
				mPresenter.rxjavaFlatMap2();
				break;
			case R.id.btn_rxjava_flatmap3:
				mPresenter.rxjavaFlatMap3();
				break;
			case R.id.btn_rxjava_flatmap4:
				mPresenter.rxjavaFlatMap4();
				break;
			case R.id.btn_rxjava_flatmap5:
				mPresenter.rxjavaFlatMap5();
				break;
			case R.id.btn_rxjava_flatmap6:

				break;
			default:
				break;
		}
	}

	@Override
	public void showtip(String s) {
		tip(s);
		LogUtils.i(s);
	}

	@Override
	public void setPresenter(RxjavaOperatorsContract.presenter presenter) {
		mPresenter = presenter;
	}
}
