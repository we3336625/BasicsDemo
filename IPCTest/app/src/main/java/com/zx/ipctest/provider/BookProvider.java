package com.zx.ipctest.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.zx.ipctest.db.DbOpenHelper;

import java.util.IllegalFormatException;

/**
 * 【类功能说明】
 *
 * @author zhangxiang
 * @version v 2.0.0 2017/8/21 下午5:22 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 */
public class BookProvider extends ContentProvider {
    private static final String TAG = BookProvider.class.getSimpleName();

    public static final String AUTHORITY = "com.zx.ipctest.provider.BookProvider";

    public static final Uri BOOK_CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/book");
    public static final Uri USER_CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/user");

    public static final int BOOK_URI_CODE = 0;
    public static final int USER_URI_CODE = 1;

    private static final UriMatcher mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        mUriMatcher.addURI(AUTHORITY, DbOpenHelper.BOOK_TABLE_NAME, BOOK_URI_CODE);
        mUriMatcher.addURI(AUTHORITY, DbOpenHelper.USER_TABLE_NAME, USER_URI_CODE);
    }

    private Context mContext;

    private SQLiteDatabase mDb;


    private void log(String log) {
        Log.i(TAG, log);
    }

    @Override
    public boolean onCreate() {
        log("  onCreate, current thread: " + Thread.currentThread().getName());

        mContext = getContext();

        initProviderData();
        return false;
    }

    private void initProviderData() {
        mDb = new DbOpenHelper(mContext).getWritableDatabase();
        // 删除表数据
        mDb.execSQL("delete from " + DbOpenHelper.USER_TABLE_NAME);
        mDb.execSQL("delete from " + DbOpenHelper.BOOK_TABLE_NAME);
        // 插入数据
        mDb.execSQL("insert into book values(3, 'android');");
        mDb.execSQL("insert into book values(4, 'ios');");
        mDb.execSQL("insert into book values(5, 'test');");

        mDb.execSQL("insert into user values(1, 'wang', 1);");
        mDb.execSQL("insert into user values(2, 'li', 0);");
    }

    private String getTableName(Uri uri) {
        String tableName = null;
        switch (mUriMatcher.match(uri)) {
            case USER_URI_CODE:
                tableName = DbOpenHelper.USER_TABLE_NAME;
                break;
            case BOOK_URI_CODE:
                tableName = DbOpenHelper.BOOK_TABLE_NAME;
                break;
            default:
                break;
        }
        return tableName;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        log("  query, current thread: " + Thread.currentThread().getName());
        String table = getTableName(uri);
        if (table == null)
            throw new IllegalArgumentException("Unsupported URI:  " + uri);
        return mDb.query(table, projection, selection, selectionArgs,null,null,sortOrder,null);
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        log("  getType");
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        log("  insert");
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        log("  delete");
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        log("  update");
        return 0;
    }
}
