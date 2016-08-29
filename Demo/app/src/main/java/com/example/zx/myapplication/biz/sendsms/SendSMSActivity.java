package com.example.zx.myapplication.biz.sendsms;

import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;

/**
 * sendSMS
 * Created by ex-zhangxiang on 2016/8/10.
 */
public class SendSMSActivity extends BaseActivity implements SendSMSContract.view{

	private static final String TAG = "SendSMSActivity";
	private EditText mEtSendSMSPhone;
	private EditText mEtSendSMSContent;
	private Button mBtnSendSMSSend;
	private SendSMSContract.presenter mPresenter;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_sendsms;
	}

	@Override
	protected void findViews() {
		super.findViews();
		mEtSendSMSPhone = (EditText) findViewById(R.id.et_sendsms_phone);
		mEtSendSMSContent = (EditText) findViewById(R.id.et_sendsms_content);
		mBtnSendSMSSend = (Button) findViewById(R.id.btn_sendsms_send);
		new SendSMSPresenter(this);
	}

	@Override
	protected void setupListeners() {
		super.setupListeners();
		mBtnSendSMSSend.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		switch (view.getId()) {
			case R.id.btn_sendsms_send:
				String phone = mEtSendSMSPhone.getText().toString();
				String content = mEtSendSMSContent.getText().toString();
				mPresenter.send(phone,content);
//				if (phone != null && phone.length()>0) {
//					if (content == null || content.equals("")){
//						tip(R.string.content_is_null);
//					} else {
//						SmsManager smsManager = SmsManager.getDefault();
//						smsManager.sendTextMessage(phone, null, content, null, null);
//						Log.i(TAG,getResources().getString(R.string.send_success));
//						mEtSendSMSContent.setText("");
//					}
//				} else {
//					tip(R.string.number_is_wrong);
//				}
				break;
			default:
				break;
		}
	}

	@Override
	public void showNull() {
		tip(R.string.content_is_null);
	}

	@Override
	public void showWrong() {
		tip(R.string.number_is_wrong);
	}

	@Override
	public void sendSMS(String phone, String content) {
		SmsManager smsManager = SmsManager.getDefault();
		smsManager.sendTextMessage(phone, null, content, null, null);
		tip(getResources().getString(R.string.send_success));
		mEtSendSMSContent.setText("");
	}

	@Override
	public void setPresenter(SendSMSContract.presenter presenter) {
		mPresenter = presenter;
	}
}
