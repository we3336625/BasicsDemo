package com.example.zx.myapplication.utils;

import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ex-zhangxiang on 2016/8/29.
 */
public class FileUtils {
	/**
	 * 存入文件中
	 * @param name	用户名
	 * @param pwd	密码
	 * @return
	 */
	public static boolean Write(String name, String pwd){
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
	public static Map<String, String> Read(){
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
