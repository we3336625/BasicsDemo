package com.zx.db.dbHelp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * 【类功能说明】
 *
 * @author zhangxiang
 * @version v 1.4.8 2017/8/3 下午2:51 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 */
public class DatabaseHelp extends SQLiteOpenHelper {

    public static final String TAG = DatabaseHelp.class.getSimpleName();

    public static final String TABLE = "dict";

    public DatabaseHelp(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DatabaseHelp(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    /**
     * 第一次创建数据库时调用
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE +
                "(" +
                "_id integer primary" +
                " key autoincrement , word , detail)");
    }

    /**
     * 数据库版本号升级时调用
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "oldVersion---> " + oldVersion + "\nnewVersion---> " + newVersion);
    }

    /**
     * 插入数据
     * @param db
     * @param word
     * @param detail
     */
    public void insertData(SQLiteDatabase db, String word, String detail) {
        db.execSQL("insert into " + TABLE + " values(null, ?, ?)", new String[]{word, detail});
    }

    /**
     * 模糊查找查找
     * @param db
     * @param key
     * @return
     */
    public Cursor query(SQLiteDatabase db, String key) {
        return db.rawQuery("select * from " + TABLE + " where word like ? or detail like ?", new String[]{"%" + key + "%", "%" + key + "%"});
    }

    /**
     * 模糊删除
     * @param db
     * @param delete
     */
    public void delete(SQLiteDatabase db, String delete) {
        db.execSQL("delete from " + TABLE + " where word like ? or detail like ?", new String[]{delete});
    }

    /**
     * 更新
     * @param db
     * @param oldWord
     * @param newWord
     */
    public void update(SQLiteDatabase db, String oldWord, String newWord) {
        db.execSQL("update " + TABLE + " set word = ?  where word = ?", new String[]{newWord, oldWord});

    }
}
