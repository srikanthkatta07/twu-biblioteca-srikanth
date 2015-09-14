//Initializing the list of books in the library
package com.twu.biblioteca;

import java.util.ArrayList;

public class LibraryFactory {

    public Library setUp() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();

        Book book1 = new Book("TWOSTATES", "CHETAN", 2008);
        Book book2 = new Book("WINGSOFFIRE", "APJ", 2007);
        Book book3 = new Book("HARRY POTTER", "JK", 2006);
        Book book4 = new Book("FIVEPOINT SOMEONE", "CHETAN", 2004);
        Book book5 = new Book("REVOLUTION 2020", "CHETAN", 2006);
        Movie movie1 = new Movie("3IDIOTS", 2009, "HIRANI", "10");
        Movie movie2 = new Movie("PK", 2014, "HIRANI", "9");
        Movie movie3 = new Movie("AVATAR", 2009, "JAMES", "10");
        Movie movie4 = new Movie("BAHUABLI", 2015, "RAJAMOULI", "UNRATED");
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        listOfBooks.add(book3);
        listOfBooks.add(book4);
        listOfBooks.add(book5);
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        return new Library(listOfBooks, movies);
    }
}
