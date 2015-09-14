package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void shouldDisplayTotalDetailsOfMovie() {
        Movie movie = new Movie("3idiots", 2009, "hirani", "10");
        String format = String.format("%-20S%-20S%-20S%-20S", "3IDIOTS", 2009, "HIRANI", "10");

        assertEquals(format, movie.getDetails());
    }
}
