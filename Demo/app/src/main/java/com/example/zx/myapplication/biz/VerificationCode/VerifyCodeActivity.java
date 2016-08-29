package com.example.zx.myapplication.biz.VerificationCode;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;
import com.example.zx.myapplication.widget.view.VerifiCodeHepler;

/**
 * 验证码
 * Created by ex-zhangxiang on 2016/8/25.
 */
public class VerifyCodeActivity extends BaseActivity implements VerifyCodeContract.View{

	private EditText mEtVerifyCode;
	private ImageView mIvVerifyCode;
	private Button mbtnVerifyCode;
	private VerifyCodeContract.Presenter mPresenter;

	@Override
	protected void findViews() {
		super.findViews();
		setTitle(R.string.verifycode);
		mEtVerifyCode = (EditText)findViewById(R.id.et_verify_code);
		mIvVerifyCode = (ImageView) findViewById(R.id.iv_verify_code);
		mbtnVerifyCode = (Button) findViewById(R.id.btn_verify_code);
	}

	@Override
	protected void initData() {
		super.initData();
		VerifyCodePresenter presenter = new VerifyCodePresenter(this,this);
		mIvVerifyCode.setImageBitmap(VerifiCodeHepler.getInstance().createBitmap());
	}

	@Override
	protected void setupListeners() {
		super.setupListeners();
		mIvVerifyCode.setOnClickListener(this);
		mbtnVerifyCode.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		switch (view.getId()){
			case R.id.iv_verify_code:  // 刷新验证码
				mPresenter.refreshVerifyCode(mIvVerifyCode);
				break;
			case R.id.btn_verify_code:  // 确认
				mPresenter.sure(mEtVerifyCode.getText().toString(),VerifiCodeHepler.getInstance().getValue());
				break;
		}
	}

	// 布局文件
	@Override
	protected int getLayoutId() {
		return R.layout.activity_verify_code;
	}


	@Override
	public void showTrueTip(String msg) {
		tip(msg);
	}

	@Override
	public void showErrorTip(String msg) {
		tip(msg);
	}

	@Override
	public void setPresenter(VerifyCodeContract.Presenter presenter) {
		mPresenter = presenter;
	}
}
