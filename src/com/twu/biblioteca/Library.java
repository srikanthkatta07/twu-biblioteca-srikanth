//It has books and it can be checked out and checked in
package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;

public class Library {

    private ArrayList<Movie> availableMovies;
    private ArrayList<Book> availableBooks;
    private ArrayList<Book> checkedOutBooks = new ArrayList<Book>();

    public Library(ArrayList<Book> listOfBooks, ArrayList<Movie> listOfMovies) {
        this.availableBooks = listOfBooks;
        this.availableMovies = listOfMovies;
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

    @Override
    public boolean equals(Object object) {
        Library that = (Library) object;
        if (that.hashCode() == this.hashCode())
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + availableBooks.hashCode();
        return hash;
    }

    public ArrayList<Movie> getAvailableMovies() {
        return availableMovies;
    }

    public boolean checkedOutMovie(String movieName) {
        return false;
    }
}
