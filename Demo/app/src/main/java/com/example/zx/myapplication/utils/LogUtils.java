package com.example.zx.myapplication.utils;

import com.example.zx.myapplication.MyApplication;
import com.orhanobut.logger.Logger;

/**
 * 打印日志工具<br/>
 * Logger.d("hello");<br/>
 * Logger.e("hello");<br/>
 * Logger.w("hello");<br/>
 * Logger.v("hello");<br/>
 * Logger.wtf("hello");<br/>
 * Logger.json(JSON_CONTENT);<br/>
 * Logger.xml(XML_CONTENT);<br/>
 * Logger.log(DEBUG, "tag", "message", throwable);<br/>
 * Created by ex-zhangxiang on 2016/9/22.
 */

public class LogUtils {

	/**
	 * 设置TAG
	 * Application 中设置
	 *
	 * @param TAG
	 */
	public static void init(String TAG) {
		Logger.init(TAG);
	}

	public static void log(int priority, String tag, String message, Throwable throwable) {
		if (MyApplication.getInstance().print) {
			Logger.log(priority, tag, message, throwable);
		}
	}

	public static void d(String message, Object... args) {
		if (MyApplication.getInstance().print) {
			Logger.d(message, args);
		}
	}

	public static void d(Object object) {
		if (MyApplication.getInstance().print) {
			Logger.d(object);
		}
	}

	public static void e(String message, Object... args) {
		if (MyApplication.getInstance().print) {
			Logger.e(message, args);
		}
	}

	public static void e(Throwable throwable, String message, Object... args) {
		if (MyApplication.getInstance().print) {
			Logger.e(throwable, message, args);
		}
	}

	public static void i(String message, Object... args) {
		if (MyApplication.getInstance().print) {
			Logger.i(message, args);
		}
	}

	public static void v(String message, Object... args) {
		if (MyApplication.getInstance().print) {
			Logger.v(message, args);
		}
	}

	public static void w(String message, Object... args) {
		if (MyApplication.getInstance().print) {
			Logger.w(message, args);
		}
	}

	public static void wtf(String message, Object... args) {
		if (MyApplication.getInstance().print) {
			Logger.wtf(message, args);
		}
	}

	public static void json(String message) {
		if (MyApplication.getInstance().print) {
			Logger.json(message);
		}
	}

	public static void xml(String message) {
		if (MyApplication.getInstance().print) {
			Logger.xml(message);
		}
	}

}
