package com.example.zx.myapplication.biz.login.register;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;

/**
 * 注册
 * Created by ex-zhangxiang on 2016/9/5.
 */
public class RegisterActivity extends BaseActivity implements RegisterContract.view {

	private EditText et_login_user;
	private EditText et_login_pwd;
	private Button btn_login;
	private EditText et_login_sure_pwd;
	private Button btn_sure;
	private RegisterContract.presenter mPresenter;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_register;
	}

	@Override
	protected void findViews() {
		super.findViews();
		et_login_user = (EditText) findViewById(R.id.et_login_user);
		et_login_pwd = (EditText) findViewById(R.id.et_login_pwd);
		btn_login = (Button) findViewById(R.id.btn_login);
		et_login_sure_pwd = (EditText) findViewById(R.id.et_login_sure_pwd);
		btn_sure = (Button) findViewById(R.id.btn_sure);

		btn_login.setVisibility(View.GONE);

		new RegisterPresenter(this, this);
	}

	@Override
	protected void setupListeners() {
		super.setupListeners();
		btn_sure.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		if (view.getId() == R.id.btn_sure) {
			String user = et_login_user.getText().toString();
			String pwd1 = et_login_pwd.getText().toString();
			String pwd2 = et_login_sure_pwd.getText().toString();
			mPresenter.sure(user, pwd1, pwd2);
		}
	}

	@Override
	public void showEmpty() {
		tip(R.string.user_pwd_empty);
	}

	@Override
	public void showError() {
		tip(R.string.pwdnotsame);
	}

	@Override
	public void toLogin() {
		tip(R.string.register_success);
		finish();
	}

	@Override
	public void setPresenter(RegisterContract.presenter presenter) {
		mPresenter = presenter;
	}
}
