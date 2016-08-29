package com.example.zx.myapplication.biz.VerificationCode;

import android.content.Context;
import android.widget.ImageView;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.widget.view.VerifiCodeHepler;

/**
 *
 * Created by ex-zhangxiang on 2016/8/25.
 */
public class VerifyCodePresenter implements VerifyCodeContract.Presenter{

	private VerifyCodeContract.View mVerificationCodeView;

	private Context mContext;

	public VerifyCodePresenter(Context context, VerifyCodeContract.View verificationCodeView){
		this.mContext = context;
		this.mVerificationCodeView = verificationCodeView;
		verificationCodeView.setPresenter(this);
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

	@Override
	public void sure(String verifyCode, String rightVerifyCode) {
		if (verifyCode.equals(rightVerifyCode)){
			mVerificationCodeView.showTrueTip(mContext.getString(R.string.istrue));
		} else {
			mVerificationCodeView.showErrorTip(mContext.getString(R.string.iserror));
		}
	}

	@Override
	public void refreshVerifyCode(ImageView imageView) {
		imageView.setImageBitmap(VerifiCodeHepler.getInstance().createBitmap());
	}

}
