package com.example.zx.myapplication.biz.VerificationCode;

import android.widget.ImageView;

import com.example.zx.myapplication.base.BasePresenter;
import com.example.zx.myapplication.base.BaseView;

/**
 * This specifies the contract between the view and presenter.
 * Created by ex-zhangxiang on 2016/8/25.
 */
public interface VerifyCodeContract {

	interface View extends BaseView<Presenter>{

		void showTrueTip(String msg);

		void showErrorTip(String msg);
	}

	interface Presenter extends BasePresenter{
		/**
		 * 验证码是否争取额
		 * @param verifyCode	输入的验证码
		 * @param rightVerifyCode  正确的验证码
		 */
		void sure(String verifyCode, String rightVerifyCode);

		/**
		 * 刷新验证码
		 * @param imageView
		 */
		void refreshVerifyCode(ImageView imageView);
	}
}
