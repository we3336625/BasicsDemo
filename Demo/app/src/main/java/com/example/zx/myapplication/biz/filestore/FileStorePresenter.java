package com.example.zx.myapplication.biz.filestore;

import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.zx.myapplication.utils.FileUtils;

import java.util.Map;

/**
 * Created by ex-zhangxiang on 2016/8/29.
 */
public class FileStorePresenter implements FileStoreContract.presenter {

	private FileStoreContract.view view;

	public FileStorePresenter(FileStoreContract.view view){
		this.view = view;
		view.setPresenter(this);
	}

	@Override
	public void saveUserName(String userName, String pwd) {
		if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(pwd)) {
			// 弹出吐司
			view.showHint();
//					return;
		}else if (view.isCheck()) {
			if (FileUtils.Write(userName, pwd)) {
				view.showSuccess();
			} else {
				view.showFail();
			}
		}
	}

	@Override
	public void displayUserName() {
		// 回显数据
		Map<String, String> userInfoMap = FileUtils.Read();
		if (userInfoMap != null){
			view.display(userInfoMap.get("number"), userInfoMap.get("password"));
		}
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
}
