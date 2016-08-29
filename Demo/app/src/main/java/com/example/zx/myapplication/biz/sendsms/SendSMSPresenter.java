package com.example.zx.myapplication.biz.sendsms;

/**
 * Created by ex-zhangxiang on 2016/8/29.
 */
public class SendSMSPresenter implements SendSMSContract.presenter {

	private SendSMSContract.view view;

	public SendSMSPresenter(SendSMSContract.view view) {
		this.view = view;
		view.setPresenter(this);
	}

	@Override
	public void send(String phone, String content) {
		if (phone != null && phone.length()>0) {
			if (content == null || content.equals("")){
				view.showNull();
			} else {
				view.sendSMS(phone, content);
			}
		} else {
			view.showWrong();
		}
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
