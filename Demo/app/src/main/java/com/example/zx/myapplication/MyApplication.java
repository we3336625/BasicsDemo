package com.example.zx.myapplication;

import android.app.Application;
import android.widget.Toast;

import com.example.zx.myapplication.utils.LogUtils;

import org.lzh.framework.updatepluginlib.UpdateConfig;
import org.lzh.framework.updatepluginlib.callback.UpdateCheckCB;
import org.lzh.framework.updatepluginlib.model.Update;
import org.lzh.framework.updatepluginlib.model.UpdateParser;
import org.lzh.framework.updatepluginlib.strategy.UpdateStrategy;

/**
 * Created by ex-zhangxiang on 2016/9/22.
 */

public class MyApplication extends Application {

	public static String TAG = "MyApplication";

	private static MyApplication instance;

	// 是否打印log
	public boolean print = true;

	public static MyApplication getInstance() {
		return instance;
	}



	@Override
	public synchronized void onCreate() {
		super.onCreate();
		instance = this;
		initAssistData();

		// Application中对Config进行配置
		UpdateConfig.getConfig()
				.url("http://www.baidu.com")// 随便模拟的一个网络接口。
				;
	}

	/**
	 * 初始化辅助工具
	 */
	private void initAssistData() {

		initThirdPartyConfig();
	}

	/**
	 * 初始化第三方库的设置
	 */
	private void initThirdPartyConfig() {
		LogUtils.init("MyLogger");

	}
}
