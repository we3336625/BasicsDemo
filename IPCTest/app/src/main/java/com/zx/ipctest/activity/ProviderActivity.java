package com.zx.ipctest.activity;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zx.ipctest.R;
import com.zx.ipctest.provider.BookProvider;

public class ProviderActivity extends AppCompatActivity {

    private static final String TAG = ProviderActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider);
        Cursor bookCursor = getContentResolver().query(BookProvider.BOOK_CONTENT_URI, new String[]{"_id", "name"}, null, null, null);
        Cursor userCursor = getContentResolver().query(BookProvider.USER_CONTENT_URI, new String[]{"_id", "name", "sex"}, null, null, null);

        while (bookCursor.moveToNext()) {
            int bookId = bookCursor.getInt(0);
            String bookName =bookCursor.getString(1);
            Log.i(TAG, "query book:  bookId----->" + bookId + "   bookName----->" + bookName);
        }

        while (userCursor.moveToNext()) {
            int userId = userCursor.getInt(0);
            String userName = userCursor.getString(1);
            String userSex = userCursor.getInt(2) == 1 ? "man" : "woman";
            Log.i(TAG, "query user:  userId----->" + userId + "   userName----->" + userName + "   userSex----->" + userSex);
        }

    }
}
