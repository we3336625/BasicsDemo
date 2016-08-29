package com.example.zx.myapplication.biz.filestore;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;
import com.example.zx.myapplication.utils.FileUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件存储
 * Created by ex-zhangxiang on 2016/8/12.
 */
public class FileStoreActivity extends BaseActivity implements FileStoreContract.view{

	EditText mEtFileStoreUsername;
	EditText mEtFileStorePwd;
	Button mBtnFileStoreLogin;
	CheckBox mCbFileStoreRemenberpwd;
	private FileStoreContract.presenter mPresenter;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_filestore;
	}

	@Override
	protected void findViews() {
		super.findViews();
		setTitle(R.string.filestore);
		mEtFileStoreUsername = (EditText) findViewById(R.id.et_filestore_username);
		mEtFileStorePwd = (EditText) findViewById(R.id.et_filestore_pwd);
		mBtnFileStoreLogin = (Button) findViewById(R.id.btn_filestore_login);
		mCbFileStoreRemenberpwd = (CheckBox) findViewById(R.id.cb_filestore_remenberpwd);
		new FileStorePresenter(this);

		mPresenter.displayUserName();
//		// 回显数据
//		Map<String, String> userInfoMap = FileUtils.Read();
//		if (userInfoMap != null){
//			mEtFileStoreUsername.setText(userInfoMap.get("number"));
//			mEtFileStorePwd.setText(userInfoMap.get("password"));
//		}
	}

	@Override
	protected void setupListeners() {
		super.setupListeners();
		mBtnFileStoreLogin.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		switch (view.getId()){
			case R.id.btn_filestore_login:
				String userName = mEtFileStoreUsername.getText().toString();
				String pwd = mEtFileStorePwd.getText().toString();

				mPresenter.saveUserName(userName, pwd);
//				if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(pwd)) {
//					// 弹出吐司
//					tip( "请正确输入");
////					return;
//				}else if (mCbFileStoreRemenberpwd.isChecked()) {
//					if (FileUtils.Write(userName, pwd)) {
//						tip("保存成功!!");
//					} else {
//						tip("保存失败");
//					}
//				}
				break;
			default:
				break;
		}
	}

	@Override
	public void showHint() {
		tip( "请正确输入");
	}

	@Override
	public void showSuccess() {
		tip("保存成功!!");
	}

	@Override
	public void showFail() {
		tip("保存失败");
	}

	@Override
	public boolean isCheck() {
		return mCbFileStoreRemenberpwd.isChecked();
	}

	@Override
	public void display(String userName, String pwd) {
		mEtFileStoreUsername.setText(userName);
		mEtFileStorePwd.setText(pwd);
	}

	@Override
	public void setPresenter(FileStoreContract.presenter presenter) {
		mPresenter = presenter;
	}
}
