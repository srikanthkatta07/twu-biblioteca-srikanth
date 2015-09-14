package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieList {
    private ArrayList<Movie> movies;

    public MovieList(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public void getAvailableMovies() {
        for (Movie movie : movies)
            System.out.println(movie.getDetails());
    }
}
