package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;

public class Library {

    private ArrayList<Book> listOfBooks;

    public Library(ArrayList<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public ArrayList<Book> getListOfBooks() {
        return listOfBooks;
    }

    public void checkedOut(String bookName) {
        Iterator<Book> iterator = listOfBooks.iterator();
        Book book=iterator.next();
        while(iterator.hasNext()) {
            if(book.equalTo(bookName)) {
                iterator.remove();
            }
        }
    }
}
