package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryFactoryTest {

    @Test
    public void shouldInitializeTheListOfBooksInTheLibrary() {
        LibraryFactory libraryFactory = new LibraryFactory();
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();

        Book book1 = new Book("TWOSTATES", "CHETAN", 2008);
        Book book2 = new Book("WINGSOFFIRE", "APJ", 2007);
        Book book3 = new Book("HARRY POTTER", "JK", 2006);
        Book book4 = new Book("FIVEPOINT SOMEONE", "CHETAN", 2004);
        Book book5 = new Book("REVOLUTION 2020", "CHETAN", 2006);
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        listOfBooks.add(book3);
        listOfBooks.add(book4);
        listOfBooks.add(book5);
        Library library = new Library(listOfBooks, movies);

        assertEquals(libraryFactory.setUp(), library);

    }
}
