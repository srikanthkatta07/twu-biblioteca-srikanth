package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    @Test
    public void shouldHaveTheListOfBooksAndItShouldGiveTheListOfBooks() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book book = new Book("Twostates", "chetan", 2008);

        listOfBooks.add(book);

        Library library = new Library(listOfBooks);

        assertEquals(listOfBooks, library.getListOfBooks());
    }

    @Test
        public void shouldNotRemoveTheBookFromListOfBooksIfTheBookNamesAreNotSame() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book book = new Book("Twostates", "chetan", 2008);

        listOfBooks.add(book);

        Library library = new Library(listOfBooks);

        library.checkedOut("abcd");
    }
}
