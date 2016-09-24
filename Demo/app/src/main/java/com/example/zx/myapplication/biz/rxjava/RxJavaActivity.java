package com.example.zx.myapplication.biz.rxjava;

import android.view.View;
import android.widget.Button;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;
import com.example.zx.myapplication.biz.rxjava.RxJavaHelloWorld.RxJavaHelloWorldActivity;
import com.example.zx.myapplication.biz.rxjava.rxjavaoperators.RxJavaOperatorsActivity;

import butterknife.BindView;

/**
 * RxJava  text
 * Created by ex-zhangxiang on 2016/9/23.
 */

public class RxJavaActivity extends BaseActivity {

	@BindView(R.id.btn_rxjava_helloworld)
	Button btn_rxjava_helloworld;
	@BindView(R.id.btn_rxjava_operators)
	Button btn_rxjava_operators;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_rxjava;
	}

	@Override
	protected void findViews() {
		super.findViews();
		setTitle(R.string.rxjava);
	}

	@Override
	protected void setupListeners() {
		super.setupListeners();
		btn_rxjava_helloworld.setOnClickListener(this);
		btn_rxjava_operators.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		if (view.getId() == R.id.btn_rxjava_helloworld) {
			startNextActivity(RxJavaHelloWorldActivity.class);
		} else if (view.getId() == R.id.btn_rxjava_operators) {
			startNextActivity(RxJavaOperatorsActivity.class);
		}
	}
}
