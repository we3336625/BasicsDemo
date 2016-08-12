package com.example.zx.myapplication.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.zx.myapplication.R;

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
public class FileStoreActivity extends BaseActivity {

	EditText mEtFileStoreUsername;
	EditText mEtFileStorePwd;
	Button mBtnFileStoreLogin;

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

		// 回显数据
		Map<String, String> userInfoMap = Read();
		if (userInfoMap != null){
			mEtFileStoreUsername.setText(userInfoMap.get("number"));
			mEtFileStorePwd.setText(userInfoMap.get("password"));
		}
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
				if (Write(userName, pwd)){
					tip("保存成功!!");
				} else {
					tip("保存失败");
				}
				break;
			default:
				break;
		}
	}

	/**
	 * 存入文件中
	 * @param name	用户名
	 * @param pwd	密码
	 * @return
	 */
	public boolean Write(String name, String pwd){
		if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pwd)){
			try {
				String uri = "/mnt/sdcard/Download/test2.txt";
				FileOutputStream fos = new FileOutputStream(uri);
				String data = name + "##" + pwd;
				fos.write(data.getBytes());
				fos.flush();
				fos.close();
				return true;
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * 从文件中读取
	 * @return
	 */
	public Map<String, String> Read(){
		try {
			String uri = "/mnt/sdcard/Download/test2.txt";
			FileInputStream fis = new FileInputStream(uri);
			// 字符流对象
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			String text = reader.readLine();
			if (!TextUtils.isEmpty(text)){
				String[] split = text.split("##");
				Map<String, String> userInfoMap = new HashMap<String, String>();
				userInfoMap.put("number", split[0]);
				userInfoMap.put("password", split[1]);
				return userInfoMap;
			}
			reader.close();
			fis.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
