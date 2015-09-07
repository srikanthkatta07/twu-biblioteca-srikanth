package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void shouldGiveNameAuthorAndPublishYearOfTheGivenBook() {
        Book book = new Book("Twostates", "chetan", 2008);

        assertEquals("Twostates chetan 2008", book.getDetails());
    }

    @Test
    public void shouldEqualToOtherBookIfBothHaveEqualNames() {
        Book book = new Book("Twostates", "chetan", 2008);

        assertEquals(true, book.equalTo("Twostates"));
    }

    @Test
    public void shouldNotEqualToOtherBookIfBothHaveDifferentNames() {
        Book book = new Book("Twostates", "chetan", 2008);

        assertEquals(false, book.equalTo("abcd"));
    }
}
