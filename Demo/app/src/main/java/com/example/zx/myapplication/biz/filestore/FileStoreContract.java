package com.example.zx.myapplication.biz.filestore;

import android.widget.CheckBox;
import android.widget.EditText;

import com.example.zx.myapplication.base.BasePresenter;
import com.example.zx.myapplication.base.BaseView;

/**
 * Created by ex-zhangxiang on 2016/8/29.
 */
public interface FileStoreContract {
	interface view extends BaseView<presenter>{
		void showHint();

		void showSuccess();

		void showFail();

		boolean isCheck();

		void display(String userName, String pwd);
	}

	interface presenter extends BasePresenter{

		void saveUserName(String userName, String pwd);

		void displayUserName();
	}
}
