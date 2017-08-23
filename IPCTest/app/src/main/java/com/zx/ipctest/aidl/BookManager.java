package com.zx.ipctest.aidl;

import android.os.IInterface;

/**
 * 【类功能说明】
 *
 * @author zhangxiang
 * @version v 2.0.0 2017/8/18 下午4:28 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 */
public interface BookManager extends IInterface {
    static final java.lang.String DESCRIPTOR = "com.zx.ipctest.aidl.IBookManager";
    static final int TRANSACTION_getBookList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_addBook = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);

    public java.util.List<com.zx.ipctest.aidl.Book> getBookList() throws android.os.RemoteException;

    public void addBook(com.zx.ipctest.aidl.Book book) throws android.os.RemoteException;
}
