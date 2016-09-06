package com.example.zx.myapplication.biz.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;
import com.example.zx.myapplication.biz.login.register.RegisterActivity;
import com.example.zx.myapplication.biz.main.MainActivity;

/**
 * 登录
 * Created by ex-zhangxiang on 2016/9/5.
 */
public class LoginActivity extends BaseActivity implements LoginContract.view {

	public static final String LOGINUSER = "login";
	public static final String LOGINPWD = "pwd";

	private EditText et_login_user;
	private EditText et_login_pwd;
	private Button btn_login;
	private Button btn_register;
	private TextView back;

	private LoginContract.presenter mPresenter;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_login;
	}

	@Override
	protected void findViews() {
		super.findViews();
		setTitle(R.string.login);
		et_login_user = (EditText) findViewById(R.id.et_login_user);
		et_login_pwd = (EditText) findViewById(R.id.et_login_pwd);
		btn_login = (Button) findViewById(R.id.btn_login);
		btn_register = (Button) findViewById(R.id.btn_register);
		back = (TextView) findViewById(R.id.back);
		back.setVisibility(View.INVISIBLE);
		new LoginPresenter(this, this);
	}

	@Override
	protected void setupListeners() {
		super.setupListeners();
		btn_login.setOnClickListener(this);
		btn_register.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		switch (view.getId()) {
			case R.id.btn_login:
				String user = et_login_user.getText().toString();
				String pwd = et_login_pwd.getText().toString();
				mPresenter.login(user, pwd);
				break;
			case R.id.btn_register:
				mPresenter.register();
				break;
			default:
				break;
		}
	}

	@Override
	public void success() {
		startNextActivity(MainActivity.class);
		finish();
	}

	@Override
	public void showEmpty() {
		tip(R.string.user_pwd_empty);
	}

	@Override
	public void showUserError() {
		tip(R.string.user_error);
	}

	@Override
	public void showPwdError() {
		tip(R.string.pwd_error);
	}

	@Override
	public void toRegister() {
		startNextActivity(RegisterActivity.class);
	}

	@Override
	public void setPresenter(LoginContract.presenter presenter) {
		mPresenter = presenter;
	}
}
