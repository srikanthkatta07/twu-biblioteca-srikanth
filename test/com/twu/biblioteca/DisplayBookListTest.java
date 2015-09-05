//To display list of books
package com.twu.biblioteca;

import org.junit.*;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DisplayBookListTest {
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
    public void shouldDisplayBookWithAuthorAndYearOfPublishWhenOnlyOneBookIsAvailable() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book book = new Book("Twostates", "chetan", 2008);

        listOfBooks.add(book);

        DisplayBookList display = new DisplayBookList(listOfBooks);

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

        DisplayBookList display = new DisplayBookList(listOfBooks);

        display.displayBookList();

        assertEquals("FirstBook FirstAuthor 2008\nSecondBook SecondAuthor 2009\n", outContent.toString());
    }
}
