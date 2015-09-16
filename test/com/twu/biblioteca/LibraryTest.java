package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LibraryTest {

    private ArrayList<Movie> movies;

    @Before
    public void setUp() {
        movies = new ArrayList<Movie>();
    }

    @Test
    public void shouldHaveTheListOfBooksAndItShouldGiveTheListOfBooks() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book book = new Book("Twostates", "chetan", 2008);

        listOfBooks.add(book);

        Library library = new Library(listOfBooks, movies);

        assertEquals(listOfBooks, library.getAvailableBooks());
    }

    @Test
    public void shouldNotRemoveTheBookFromListOfBooksIfTheBookNamesAreNotSame() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book book = new Book("Twostates", "chetan", 2008);

        listOfBooks.add(book);

        Library library = new Library(listOfBooks, movies);

        assertEquals(false, library.checkedOut("abcd"));
    }

    @Test
    public void shouldRemoveTheBookFromListOfBooksIfTheBookNamesAreSame() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book book = new Book("Twostates", "chetan", 2008);

        listOfBooks.add(book);

        Library library = new Library(listOfBooks, movies);

        assertEquals(true, library.checkedOut("Twostates"));
    }

    @Test
    public void shouldTakeValidBookNameFromTheUserAndAddToTheLibrary() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book book = new Book("Twostates", "chetan", 2008);

        listOfBooks.add(book);

        Library library = new Library(listOfBooks, movies);

        library.checkedOut("Twostates");

        assertEquals(true, library.checkedIn("Twostates"));
    }

    @Test
    public void shouldNotAddToTheLibraryIfTheGivenBookNameIsNotValid() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book book = new Book("Twostates", "chetan", 2008);

        listOfBooks.add(book);

        Library library = new Library(listOfBooks, movies);

        library.checkedOut("Twostates");

        assertEquals(false, library.checkedIn("abcd"));
    }

    @Test
    public void shouldEqualsToAnotherLibraryIfBothHaveSameListOfAvailableBooks() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book book = new Book("Twostates", "chetan", 2008);

        listOfBooks.add(book);

        Library library = new Library(listOfBooks, movies);
        Library anotherLibrary = new Library(listOfBooks, movies);

        assertEquals(anotherLibrary, library);
    }

    @Test
    public void shouldNotEqualsToAnotherLibraryIfBothHaveDifferentListOfAvailableBooks() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        ArrayList<Book> listOfBooks1 = new ArrayList<Book>();
        Book book = new Book("Twostates", "chetan", 2008);
        Book anotherBook = new Book("FivePoint", "chetan", 2009);

        listOfBooks.add(book);
        listOfBooks1.add(anotherBook);

        Library library = new Library(listOfBooks, movies);
        Library anotherLibrary = new Library(listOfBooks1, movies);

        assertNotEquals(anotherLibrary, library);
    }

    @Test
    public void shouldDisplayTheListOfMoviesToTheUser() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Movie movie = new Movie("3IDIOTS", 2009, "HIRANI", "10");

        movies.add(movie);

        Library library = new Library(listOfBooks, movies);

        assertEquals(movies, library.getAvailableMovies());
    }

    @Test
    public void shouldNotRemoveTheMovieFromListOfMoviesIfTheMovieNamesAreNotSame() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Movie movie = new Movie("3IDIOTS", 2009, "HIRANI", "10");

        movies.add(movie);

        Library library = new Library(listOfBooks, movies);

        assertEquals(false, library.checkedOutMovie("abcd"));
    }

    @Test
    public void shouldRemoveTheMovieFromListOfMoviesIfTheMovieNamesAreSame() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Movie movie = new Movie("3IDIOTS", 2009, "HIRANI", "10");

        movies.add(movie);

        Library library = new Library(listOfBooks, movies);

        assertEquals(true, library.checkedOutMovie("3IDIOTS"));
    }
}
