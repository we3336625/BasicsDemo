# BasicsDemo
	

MVP模式：
	




SharedPreferences(login，register): SharedPreferences的使用
	// 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
	public static void put(Context context, String key, Object object) {

		SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();

		if (object instanceof String) {
			editor.putString(key, (String) object);
		} else if (object instanceof Integer) {
			editor.putInt(key, (Integer) object);
		} else if (object instanceof Boolean) {
			editor.putBoolean(key, (Boolean) object);
		} else if (object instanceof Float) {
			editor.putFloat(key, (Float) object);
		} else if (object instanceof Long) {
			editor.putLong(key, (Long) object);
		} else {
			editor.putString(key, object.toString());
		}

		SharedPreferencesCompat.apply(editor);
	}	
	// 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
	public static Object get(Context context, String key, Object defaultObject) {
		SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
				Context.MODE_PRIVATE);

		if (defaultObject instanceof String) {
			return sp.getString(key, (String) defaultObject);
		} else if (defaultObject instanceof Integer) {
			return sp.getInt(key, (Integer) defaultObject);
		} else if (defaultObject instanceof Boolean) {
			return sp.getBoolean(key, (Boolean) defaultObject);
		} else if (defaultObject instanceof Float) {
			return sp.getFloat(key, (Float) defaultObject);
		} else if (defaultObject instanceof Long) {
			return sp.getLong(key, (Long) defaultObject);
		}

		return null;
	}


SQLite: sqlite基本运用
	// 创建db
	public void creatdb(Context context) {
		TestDbHelper testDbHelper = new TestDbHelper(context, "stu_db", null, 1);
		testDbHelper.getReadableDatabase();
	}	
	// db升级
	public void updatedb(Context context) {
		new TestDbHelper(context, "stu_db", null, 2);
	}
	// 增
	public void insert(Context context) {
		TestDbHelper testDbHelper = new TestDbHelper(context, "stu_db", null, 2);
		testDbHelper.SqlInsert(testDbHelper, "xiaoming", 21, "male");
	}
	// 删
	public void delete(Context context) {
		TestDbHelper testDbHelper = new TestDbHelper(context, "stu_db", null, 2);
		SQLiteDatabase db = testDbHelper.getWritableDatabase();
		String whereClauses = "id=?";
		String [] whereArg = {String.valueOf(1)};
		//调用delete方法，删除数据
		db.delete("stu_table", whereClauses, whereArg);
	}
	// 改
	public void update(Context context) {
		TestDbHelper testDbHelper = new TestDbHelper(context, "stu_db", null, 2);
		SQLiteDatabase db  = testDbHelper.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("sage", "23");
		//where 子句 "?"是占位符号，对应后面的"1",
		String whereClause="id=?";
		String [] whereArgs = {String.valueOf(1)};
		//参数1 是要更新的表名
		//参数2 是一个ContentValeus对象
		//参数3 是where子句
		db.update("stu_table", contentValues, whereClause, whereArgs);
	}
	// 查
	public void query(Context context) {
		TestDbHelper testDbHelper = new TestDbHelper(context, "stu_db", null, 2);
		SQLiteDatabase db = testDbHelper.getReadableDatabase();
		//参数1：表名
		//参数2：要想显示的列
		//参数3：where子句
		//参数4：where子句对应的条件值
		//参数5：分组方式
		//参数6：having条件
		//参数7：排序方式
		Cursor cursor = db.query("stu_table", new String[]{"id", "sname", "sage", "ssex"}, "id=?", new String[]{"1"}, null, null, null);
		while (cursor.moveToNext()) {
			String name = cursor.getString(cursor.getColumnIndex("sname"));
			String age = cursor.getString(cursor.getColumnIndex("sage"));
			String sex = cursor.getString(cursor.getColumnIndex("ssex"));
			System.out.println("query------->" + "姓名：" + name + " " + "年龄：" + age + " " + "性别：" + sex);
		}
		//关闭数据库
		db.close();
	}

call phone: 打电话
	// 设置intent的action， 调用系统CALL
	if (number != null && number.length() > 0) {
		Uri uri = Uri.parse("tel:" + number);
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_CALL);
		intent.setData(uri);
		view.toActivity(intent);
	} else {
		view.showErrorTip();
	}

send SMS: 发送短信
	// 通过SmsManager进行短信的发送，  phone：号码   content：内容
	SmsManager smsManager = SmsManager.getDefault();
	smsManager.sendTextMessage(phone, null, content, null, null);


filestore: 文件存储
	// 存入文件中
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
	// 从文件中读取
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

VerificationCode: 本地验证码
	// 
	


select bank
	
eventbus
RxJava
ConvenientBanner