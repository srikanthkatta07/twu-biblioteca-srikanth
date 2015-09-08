package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;

public class Library {

    private ArrayList<Book> availableBooks;
    private ArrayList<Book> checkedOutBooks = new ArrayList<Book>();

    public Library(ArrayList<Book> listOfBooks) {
        this.availableBooks = listOfBooks;
    }

    public ArrayList<Book> getAvailableBooks() {
        return availableBooks;
    }

    public boolean checkedOut(String bookName) {
        Iterator<Book> iterator = availableBooks.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.findByBookName(bookName)) {
                checkedOutBooks.add(book);
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean checkedIn(String bookName) {
        Iterator<Book> iterator = checkedOutBooks.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.findByBookName(bookName)) {
                availableBooks.add(book);
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
