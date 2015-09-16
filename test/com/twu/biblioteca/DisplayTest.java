package com.twu.biblioteca;

import org.junit.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DisplayTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ArrayList<Movie> movies;

    @Before
    public void setUp() {
        movies = new ArrayList<Movie>();
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }

    @Test
    public void shouldDisplayWelcomeMessage() {

        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Library library = new Library(listOfBooks, movies);
        Display welcomeMessage = new Display(library);

        welcomeMessage.displayMessage("Welcome to Biblioteca");

        assertEquals("Welcome to Biblioteca\n", outContent.toString());
    }

    @Test
    public void shouldDisplayBookWithAuthorAndYearOfPublishWhenOnlyOneBookIsAvailable() {

        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book book = new Book("TWOSTATES", "CHETAN", 2008);

        listOfBooks.add(book);

        Library library = new Library(listOfBooks, movies);
        Display display = new Display(library);

        display.displayBookList();

        String headrLines = String.format("----------------------------------------------------------------");

        String header = String.format("%-20S%-20S%-20S", "NAME", "AUTHOR", "YEAR OF PUBLISH");

        String format = String.format("%-20S%-20S%-20S", "TWOSTATES", "CHETAN", 2008);

        assertEquals(headrLines + "\n" + header + "\n" + headrLines + "\n" + format + "\n", outContent.toString());
    }

    @Test
    public void shouldDisplayListOfBooksWithAuthorAndYearOfPublishWhenMoreThanOneBookIsAvailable() {

        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book firstBook = new Book("FIRSTBOOK", "FIRSTAUTHOR", 2008);
        Book secondBook = new Book("SECONDBOOK", "SECONDAUTHOR", 2009);

        listOfBooks.add(firstBook);
        listOfBooks.add(secondBook);

        Library library = new Library(listOfBooks, movies);
        Display display = new Display(library);

        display.displayBookList();
        String headrLines = String.format("----------------------------------------------------------------");
        String header = String.format("%-20S%-20S%-20S", "NAME", "AUTHOR", "YEAR OF PUBLISH");
        String book1 = String.format("%-20S%-20S%-20S", "FIRSTBOOK", "FIRSTAUTHOR", 2008);
        String book2 = String.format("%-20S%-20S%-20S", "SECONDBOOK", "SECONDAUTHOR", 2009);

        assertEquals(headrLines + "\n" + header + "\n" + headrLines + "\n" + book1 + "\n" + book2 + "\n", outContent.toString());
    }

    @Test
    public void shouldDisplayInvalidCommandWhenUserEntersInvalidOption() {

        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Library library = new Library(listOfBooks, movies);
        Display display = new Display(library);

        display.displayInvalidCommand();

        assertEquals("Select an valid option!\n", outContent.toString());
    }

    @Test
    public void shouldDisplaySuccessfulCheckoutMessageToTheUser() {

        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Library library = new Library(listOfBooks, movies);
        Display display = new Display(library);

        display.displaySuccessfulCheckOut();

        assertEquals("Thank you! Enjoy the book\n", outContent.toString());
    }

    @Test
    public void shouldDisplayUnSuccessfulCheckoutMessageToTheUser() {

        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Library library = new Library(listOfBooks, movies);
        Display display = new Display(library);

        display.displayUnSuccessfulCheckOut();

        assertEquals("That book is not available\n", outContent.toString());
    }

    @Test
    public void shouldDisplayMessageWhenUserReturnedTheValidBook() {

        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Library library = new Library(listOfBooks, movies);
        Display display = new Display(library);

        display.displaySuccessfulReturn();

        assertEquals("Thank you for returning the book\n", outContent.toString());
    }

    @Test
    public void shouldDisplayMessageWhenUserReturnedTheUnValidBook() {

        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Library library = new Library(listOfBooks, movies);
        Display display = new Display(library);

        display.displayUnSuccessfulReturn();

        assertEquals("That is not a valid book to return\n", outContent.toString());
    }

    @Test
    public void displayTheHeaderToTheBookList() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book book = new Book("TWOSTATES", "CHETAN", 2008);

        listOfBooks.add(book);

        Library library = new Library(listOfBooks, movies);
        Display display = new Display(library);

        display.displayBookList();

        String headrLines = String.format("----------------------------------------------------------------");

        String header = String.format("%-20S%-20S%-20S", "NAME", "AUTHOR", "YEAR OF PUBLISH");

        String format = String.format("%-20S%-20S%-20S", "TWOSTATES", "CHETAN", 2008);

        assertEquals(headrLines + "\n" + header + "\n" + headrLines + "\n" + format + "\n", outContent.toString());
    }

    @Test
    public void displayTheListOfAvailableMoviesToTheUser() {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Movie movie = new Movie("3IDIOTS", 2009, "HIRANI", "10");

        movies.add(movie);

        Library library = new Library(listOfBooks, movies);
        Display display = new Display(library);

        display.displayMovieList();

        String headrLines = String.format("----------------------------------------------------------------");

        String header = String.format("%-20S%-20S%-20S%-20S", "NAME", "YEAR", "DIRECTOR", "RATING");

        String format = String.format("%-20S%-20S%-20S%-20S", "3IDIOTS", 2009, "HIRANI", "10");

        assertEquals(headrLines + "\n" + header + "\n" + headrLines + "\n" + format + "\n", outContent.toString());
    }

    @Test
    public void shouldDisplaySuccessfulMovieCheckoutMessageToTheUser() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Library library = new Library(listOfBooks, movies);
        Display display = new Display(library);

        display.displaySuccessfulMovieCheckOut();

        assertEquals("Thank you! Enjoy the Movie\n", outContent.toString());
    }

    @Test
    public void shouldDisplayUnSuccessfulMovieCheckoutMessageToTheUser() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Library library = new Library(listOfBooks, movies);
        Display display = new Display(library);

        display.displayUnSuccessfulMovieCheckOut();

        assertEquals("That movie is not available\n", outContent.toString());
    }

    @Test
    public void shouldDisplayInvalidOptionMessageWhenUserEntersInvalidOption() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Library library = new Library(listOfBooks, movies);
        Display display = new Display(library);

        display.displayInvalidOptionMessage();

        assertEquals("Enter valid option\n", outContent.toString());
    }


}
