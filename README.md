# BasicsDemo
	

MVPģʽ��
	




SharedPreferences(login��register): SharedPreferences��ʹ��
	// �������ݵķ�����������Ҫ�õ��������ݵľ������ͣ�Ȼ��������͵��ò�ͬ�ı��淽��
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
	// �õ��������ݵķ��������Ǹ���Ĭ��ֵ�õ���������ݵľ������ͣ�Ȼ���������ڵķ�����ȡֵ
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


SQLite: sqlite��������
	// ����db
	public void creatdb(Context context) {
		TestDbHelper testDbHelper = new TestDbHelper(context, "stu_db", null, 1);
		testDbHelper.getReadableDatabase();
	}	
	// db����
	public void updatedb(Context context) {
		new TestDbHelper(context, "stu_db", null, 2);
	}
	// ��
	public void insert(Context context) {
		TestDbHelper testDbHelper = new TestDbHelper(context, "stu_db", null, 2);
		testDbHelper.SqlInsert(testDbHelper, "xiaoming", 21, "male");
	}
	// ɾ
	public void delete(Context context) {
		TestDbHelper testDbHelper = new TestDbHelper(context, "stu_db", null, 2);
		SQLiteDatabase db = testDbHelper.getWritableDatabase();
		String whereClauses = "id=?";
		String [] whereArg = {String.valueOf(1)};
		//����delete������ɾ������
		db.delete("stu_table", whereClauses, whereArg);
	}
	// ��
	public void update(Context context) {
		TestDbHelper testDbHelper = new TestDbHelper(context, "stu_db", null, 2);
		SQLiteDatabase db  = testDbHelper.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("sage", "23");
		//where �Ӿ� "?"��ռλ���ţ���Ӧ�����"1",
		String whereClause="id=?";
		String [] whereArgs = {String.valueOf(1)};
		//����1 ��Ҫ���µı���
		//����2 ��һ��ContentValeus����
		//����3 ��where�Ӿ�
		db.update("stu_table", contentValues, whereClause, whereArgs);
	}
	// ��
	public void query(Context context) {
		TestDbHelper testDbHelper = new TestDbHelper(context, "stu_db", null, 2);
		SQLiteDatabase db = testDbHelper.getReadableDatabase();
		//����1������
		//����2��Ҫ����ʾ����
		//����3��where�Ӿ�
		//����4��where�Ӿ��Ӧ������ֵ
		//����5�����鷽ʽ
		//����6��having����
		//����7������ʽ
		Cursor cursor = db.query("stu_table", new String[]{"id", "sname", "sage", "ssex"}, "id=?", new String[]{"1"}, null, null, null);
		while (cursor.moveToNext()) {
			String name = cursor.getString(cursor.getColumnIndex("sname"));
			String age = cursor.getString(cursor.getColumnIndex("sage"));
			String sex = cursor.getString(cursor.getColumnIndex("ssex"));
			System.out.println("query------->" + "������" + name + " " + "���䣺" + age + " " + "�Ա�" + sex);
		}
		//�ر����ݿ�
		db.close();
	}

call phone: ��绰
	// ����intent��action�� ����ϵͳCALL
	if (number != null && number.length() > 0) {
		Uri uri = Uri.parse("tel:" + number);
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_CALL);
		intent.setData(uri);
		view.toActivity(intent);
	} else {
		view.showErrorTip();
	}

send SMS: ���Ͷ���
	// ͨ��SmsManager���ж��ŵķ��ͣ�  phone������   content������
	SmsManager smsManager = SmsManager.getDefault();
	smsManager.sendTextMessage(phone, null, content, null, null);


filestore: �ļ��洢
	// �����ļ���
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
	// ���ļ��ж�ȡ
	public static Map<String, String> Read(){
		try {
			String uri = "/mnt/sdcard/Download/test2.txt";
			FileInputStream fis = new FileInputStream(uri);
			// �ַ�������
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

VerificationCode: ������֤��
	// 
	


select bank
	
eventbus
RxJava
ConvenientBanner