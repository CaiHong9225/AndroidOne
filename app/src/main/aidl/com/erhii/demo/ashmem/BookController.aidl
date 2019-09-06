// BookController.aidl
package com.erhii.demo.ashmem;

import com.erhii.demo.ashmem.bean.Book;



// Declare any non-default types here with import statements

interface BookController {

    List<Book> getBookList();

    void addBookInOut(inout Book book);

    void addBookIn(in Book book);

    void addBookOut(out Book book);

}
