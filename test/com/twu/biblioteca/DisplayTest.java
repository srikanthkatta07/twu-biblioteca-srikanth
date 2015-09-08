//To display list of books
package com.twu.biblioteca;

import org.junit.*;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class DisplayTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

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
        Library library = new Library(listOfBooks);
        Display welcomeMessage = new Display(library);

        welcomeMessage.displayMessage("Welcome to Biblioteca");

        assertEquals("Welcome to Biblioteca\n", outContent.toString());
    }

    @Test
    public void shouldDisplayBookWithAuthorAndYearOfPublishWhenOnlyOneBookIsAvailable() {

        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book book = new Book("Twostates", "chetan", 2008);

        listOfBooks.add(book);

        Library library = new Library(listOfBooks);
        Display display = new Display(library);

        display.displayBookList();

        assertEquals("Twostates chetan 2008\n", outContent.toString());
    }

    @Test
    public void shouldDisplayListOfBooksWithAuthorAndYearOfPublishWhenMoreThanOneBookIsAvailable() {

        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book firstBook = new Book("FirstBook", "FirstAuthor", 2008);
        Book secondBook = new Book("SecondBook", "SecondAuthor", 2009);

        listOfBooks.add(firstBook);
        listOfBooks.add(secondBook);

        Library library = new Library(listOfBooks);
        Display display = new Display(library);

        display.displayBookList();

        assertEquals("FirstBook FirstAuthor 2008\nSecondBook SecondAuthor 2009\n", outContent.toString());
    }

    @Test
    public void shouldDisplayInvalidCommandWhenUserEntersInvalidOption() {

        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Library library = new Library(listOfBooks);
        Display display = new Display(library);

        display.displayInvalidCommand();

        assertEquals("Select an valid option!\n", outContent.toString());
    }

    @Test
    public void shouldDisplaySuccessfulCheckoutMessageToTheUser() {

        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Library library = new Library(listOfBooks);
        Display display = new Display(library);

        display.displaySuccessfulCheckOut();

        assertEquals("Thank you! Enjoy the book\n", outContent.toString());
    }

    @Test
    public void shouldDisplayUnSuccessfulCheckoutMessageToTheUser() {

        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Library library = new Library(listOfBooks);
        Display display = new Display(library);

        display.displayUnSuccessfulCheckOut();

        assertEquals("That book is not available\n", outContent.toString());
    }
}
