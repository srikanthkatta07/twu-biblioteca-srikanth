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
    public void shouldDisplayListOfBooksWhenOnlyOneBookIsAvailable() {
        ArrayList<String> listOfBooks = new ArrayList<String>();

        listOfBooks.add("First book");

        DisplayBookList display = new DisplayBookList(listOfBooks);

        display.displayBookList();

        assertEquals("First book\n", outContent.toString());
    }

    @Test
    public void shouldDisplayListOfBooksWhenMoreThanOneBook() {
        ArrayList<String> listOfBooks = new ArrayList<String>();

        listOfBooks.add("First book");
        listOfBooks.add("Second book");
        listOfBooks.add("Third book");

        DisplayBookList display = new DisplayBookList(listOfBooks);

        display.displayBookList();

        assertEquals("First book\nSecond book\nThird book\n", outContent.toString());
    }


}
