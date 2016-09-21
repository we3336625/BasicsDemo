package com.example.zx.myapplication.biz.eventbus.eventbusfirst;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;
import com.example.zx.myapplication.biz.eventbus.FirstEvent;
import com.example.zx.myapplication.biz.eventbus.eventbussecond.EventBusSecondActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class EventBusFirstActivity extends BaseActivity {

	Button btn_eventbus_to_next;
	TextView tv_eventbus_show;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_event_bus_first;
	}

	@Override
	protected void findViews() {
		super.findViews();
		// 注册eventbus
		EventBus.getDefault().register(this);
		setTitle(R.string.eventbus_first);
		btn_eventbus_to_next = (Button) findViewById(R.id.btn_eventbus_to_next);
		tv_eventbus_show = (TextView) findViewById(R.id.tv_eventbus_show);
	}

	@Override
	protected void setupListeners() {
		super.setupListeners();
		btn_eventbus_to_next.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		if (view.getId() == R.id.btn_eventbus_to_next){
			startNextActivity(EventBusSecondActivity.class);
		}
	}

	@Subscribe
	public void onEventMainThread(FirstEvent event){
		String msg = "接收到：" + event.getMsg();
		tv_eventbus_show.setText(msg);
		tip(msg);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// 反注册eventbus
		EventBus.getDefault().unregister(this);
	}
}
