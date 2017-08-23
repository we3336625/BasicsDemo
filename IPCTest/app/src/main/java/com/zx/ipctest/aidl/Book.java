/*
 *
 *  * 乡邻小站
 *  *   *Copyright (c) 2017 XiangLin,Inc.All Rights Reserved.
 *
 */

package com.zx.ipctest.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 【类功能说明】
 *
 * @author zhangxiang
 * @version v 2.0.0 2017/8/18 下午3:21 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 */
public class Book implements Parcelable {

    public int bookId;
    public String bookName;

    protected Book(Parcel in) {
        bookId = in.readInt();
        bookName = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(bookId);
        dest.writeString(bookName);
    }
}
