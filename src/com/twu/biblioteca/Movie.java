//Returning the details of the movie
package com.twu.biblioteca;

public class Movie {
    private String name;
    private int year;
    private String director;
    private String rating;

    public Movie(String name, int year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getDetails() {
        return String.format("%-20S%-20S%-20S%-20S", name, year, director, rating);
    }
}
