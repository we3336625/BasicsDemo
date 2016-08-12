package com.example.zx.myapplication.activity;

import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.zx.myapplication.R;

/**
 * sendSMS
 * Created by ex-zhangxiang on 2016/8/10.
 */
public class SendSMSActivity extends BaseActivity {

	private static final String TAG = "SendSMSActivity";
	private EditText mEtSendSMSPhone;
	private EditText mEtSendSMSContent;
	private Button mBtnSendSMSSend;

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
				if (phone != null && phone.length()>0) {
					if (content == null || content.equals("")){
						tip(R.string.content_is_null);
					} else {
						SmsManager smsManager = SmsManager.getDefault();
						smsManager.sendTextMessage(phone, null, content, null, null);
						Log.i(TAG,getResources().getString(R.string.send_success));
						mEtSendSMSContent.setText("");
					}
				} else {
					tip(R.string.number_is_wrong);
				}
				break;
			default:
				break;
		}
	}
}
