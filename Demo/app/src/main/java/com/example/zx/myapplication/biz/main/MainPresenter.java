package com.example.zx.myapplication.biz.main;

import android.content.Context;

/**
 * Created by ex-zhangxiang on 2016/8/26.
 */
public class MainPresenter implements MainContract.Presenter {

	private Context mContext;
	private MainContract.view view;

	public MainPresenter(Context context, MainContract.view view) {
		this.mContext = context;
		this.view = view;
		view.setPresenter(this);
	}

	@Override
	public void startNetxtActivity(Class cls) {
		view.startActivity(cls);
	}

	@Override
	public void start() {

	}

	@Override
	public void subscribe() {

	}

	@Override
	public void unsubscribe() {

	}
}
