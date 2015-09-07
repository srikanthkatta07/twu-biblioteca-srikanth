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
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.equalTo(bookName)) {
                iterator.remove();
            }
        }
    }
}
