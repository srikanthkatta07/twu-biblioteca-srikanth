package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LibraryTest {

    private ArrayList<Movie> movies;
    private User user;

    @Before
    public void setUp() {
        movies = new ArrayList<Movie>();
        user = new User("123-7777", "abcd123", "srikanth", "9666837099", "s@gmail.com", "librarian");
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

        assertEquals(false, library.checkedOut("abcd", user));
    }

    @Test
    public void shouldRemoveTheBookFromListOfBooksIfTheBookNamesAreSame() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book book = new Book("Twostates", "chetan", 2008);

        listOfBooks.add(book);

        Library library = new Library(listOfBooks, movies);

        assertEquals(true, library.checkedOut("Twostates", user));
    }

    @Test
    public void shouldTakeValidBookNameFromTheUserAndAddToTheLibrary() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book book = new Book("Twostates", "chetan", 2008);

        listOfBooks.add(book);

        Library library = new Library(listOfBooks, movies);

        library.checkedOut("Twostates", user);

        assertEquals(true, library.checkedIn("Twostates", user));
    }

    @Test
    public void shouldNotAddToTheLibraryIfTheGivenBookNameIsNotValid() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book book = new Book("Twostates", "chetan", 2008);

        listOfBooks.add(book);

        Library library = new Library(listOfBooks, movies);

        library.checkedOut("Twostates", user);

        assertEquals(false, library.checkedIn("abcd", user));
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

    @Test
    public void shouldAddTheUserToTheListOfUsersWhenHeCheckedOutBook() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book book = new Book("Twostates", "chetan", 2008);

        listOfBooks.add(book);

        Library library = new Library(listOfBooks, movies);
        library.checkedOut("Twostates", user);

        String format = String.format("%-20S%-20S%-20S%-20S%-20S%-20S%-20S\n", "TWOSTATES", "CHETAN",2008,"srikanth","9666837099","s@gmail.com","librarian");

        assertEquals(format, library.getCheckedOutUsers());
    }

    @Test
    public void shouldRemoveTheUserFromChekedOutUsersListWhenHeCheckedInBook() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();

        Book book1 = new Book("Twostates", "chetan", 2008);
        Book book2 = new Book("Fivepoints", "chetan", 2008);

        listOfBooks.add(book1);
        listOfBooks.add(book2);

        Library library = new Library(listOfBooks, movies);
        library.checkedOut("Twostates", user);
        library.checkedOut("Fivepoints", user);
        library.checkedIn("Twostates", user);

        String format = String.format("%-20S%-20S%-20S%-20S%-20S%-20S%-20S\n", "FIVEPOINTS", "CHETAN",2008,"srikanth","9666837099","s@gmail.com","librarian");

        assertEquals(format, library.getCheckedOutUsers());
    }
}
