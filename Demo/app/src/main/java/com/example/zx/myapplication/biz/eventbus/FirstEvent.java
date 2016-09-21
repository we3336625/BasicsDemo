package com.example.zx.myapplication.biz.eventbus;

/**
 * Created by ex-zhangxiang on 2016/9/21.
 */

public class FirstEvent {

	private String msg;
	

	public FirstEvent(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

}
