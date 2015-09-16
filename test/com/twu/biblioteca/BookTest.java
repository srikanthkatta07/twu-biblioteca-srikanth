package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void shouldGiveNameAuthorAndPublishYearOfTheGivenBook() {
        Book book = new Book("Twostates", "chetan", 2008);

        String format = String.format("%-20S%-20S%-20S", "TWOSTATES", "CHETAN", 2008);

        assertEquals(format, book.getDetails());
    }

    @Test
    public void shouldEqualToOtherBookIfBothHaveEqualNames() {
        Book book = new Book("Twostates", "chetan", 2008);

        assertEquals(true, book.findByBookName("Twostates"));
    }

    @Test
    public void shouldNotEqualToOtherBookIfBothHaveDifferentNames() {
        Book book = new Book("Twostates", "chetan", 2008);

        assertEquals(false, book.findByBookName("abcd"));
    }

    @Test
    public void shouldEqualToOtherBookIfBothHaveSameBookDetails() {
        Book firstBook = new Book("Twostates", "chetan", 2008);
        Book secondBook = new Book("Twostates", "chetan", 2008);

        assertEquals(firstBook, secondBook);
    }

    @Test
    public void shouldNotEqualToOtherBookIfBothHaveDifferentBookDetails() {
        Book firstBook = new Book("Twostates", "chetan", 2008);
        Book secondBook = new Book("Twostat", "chetan", 2008);

        assertNotEquals(firstBook, secondBook);
    }
}
