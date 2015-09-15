//To display all the messages to the user
package com.twu.biblioteca;

public class Display {

    private Library library;

    public Display(Library library) {
        this.library = library;

    }

    public void displayBookList() {
        System.out.println(String.format("----------------------------------------------------------------"));
        System.out.println(String.format("%-20S%-20S%-20S", "NAME", "AUTHOR", "YEAR OF PUBLISH"));
        System.out.println(String.format("----------------------------------------------------------------"));
        for (Book book : library.getAvailableBooks())
            System.out.println(book.getDetails());
    }

    public void displayInvalidCommand() {
        System.out.println("Select an valid option!");
    }

    public void displayMessage(String welcomeMessage) {
        System.out.println(welcomeMessage);
    }

    public void exitMenu() {
        System.exit(0);
    }

    public void displaySuccessfulCheckOut() {
        System.out.println("Thank you! Enjoy the book");
    }

    public void displayUnSuccessfulCheckOut() {
        System.out.println("That book is not available");
    }

    public void displaySuccessfulReturn() {
        System.out.println("Thank you for returning the book");
    }

    public void displayUnSuccessfulReturn() {
        System.out.println("That is not a valid book to return");
    }

    public void displayMovieList() {
        System.out.println(String.format("----------------------------------------------------------------"));
        System.out.println(String.format("%-20S%-20S%-20S%-20S", "NAME", "YEAR", "DIRECTOR", "RATING"));
        System.out.println(String.format("----------------------------------------------------------------"));
        for (Movie movie : library.getAvailableMovies()) {
            System.out.println(movie.getDetails());
        }
    }

    public void displaySuccessfulMovieCheckOut() {
        System.out.println("Thank you! Enjoy the Movie");
    }
}
