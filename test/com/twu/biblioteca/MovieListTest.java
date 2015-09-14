package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MovieListTest {

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
    public void shouldDisplayTheListOfMoviesInTheMovieList() {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Movie movie = new Movie("3IDIOTS", 2009, "HIRANI", "10");
        Movie movie1 = new Movie("PK", 2014, "HIRANI", "10");

        movies.add(movie);
        movies.add(movie1);

        MovieList movieList = new MovieList(movies);
        String format = String.format("%-20S%-20S%-20S%-20S\n%-20S%-20S%-20S%-20S", "3IDIOTS", 2009, "HIRANI", "10", "PK", 2014, "HIRANI", "10");

        movieList.getAvailableMovies();

        assertEquals(format + "\n", outContent.toString());
    }
}
