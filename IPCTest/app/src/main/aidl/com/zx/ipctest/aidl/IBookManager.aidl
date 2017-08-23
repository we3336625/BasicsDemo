// IBookManager.aidl
package com.zx.ipctest.aidl;

import com.zx.ipctest.aidl.Book;

interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);
}
