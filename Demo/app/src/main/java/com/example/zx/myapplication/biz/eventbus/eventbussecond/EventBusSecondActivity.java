package com.example.zx.myapplication.biz.eventbus.eventbussecond;

import android.view.View;
import android.widget.Button;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;
import com.example.zx.myapplication.biz.eventbus.FirstEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;

public class EventBusSecondActivity extends BaseActivity {

	@BindView(R.id.btn_eventbus_to_first)
	Button btn_eventbus_to_first;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_event_bus_second;
	}

	@Override
	protected void findViews() {
		super.findViews();
		setTitle(R.string.eventbus_second);
	}

	@Override
	protected void setupListeners() {
		super.setupListeners();
		btn_eventbus_to_first.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		if (view.getId() == R.id.btn_eventbus_to_first) {
			EventBus.getDefault().post(new FirstEvent("button is click!"));
		}
	}
}
