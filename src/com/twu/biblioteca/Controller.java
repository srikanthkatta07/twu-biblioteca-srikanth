//It delegates the user choices
package com.twu.biblioteca;

public class Controller {

    private Library library;
    private ConsoleInput consoleInput;
    private Display display;

    public Controller(Display display, ConsoleInput consoleInput, Library library) {
        this.display = display;
        this.consoleInput = consoleInput;
        this.library = library;
    }

    public void delegate(String option) {
        if (option.equals("1"))
            display.displayBookList();
        else if (option.equals("2"))
            checkOut();
        else if (option.equals("3"))
            checkIn();
        else if (option.equals("4"))
            display.exitMenu();
        else if (option.equals("5"))
            display.displayMovieList();
        else if (option.equals("6"))
            checkOutMovie();
        else
            display.displayInvalidCommand();
    }

    private void checkOutMovie() {
        if (library.checkedOutMovie(consoleInput.takeInput()))
            display.displaySuccessfulMovieCheckOut();
        else
            display.displayUnSuccessfulMovieCheckOut();
    }

    private void checkOut() {
        if (library.checkedOut(consoleInput.takeInput()))
            display.displaySuccessfulCheckOut();
        else
            display.displayUnSuccessfulCheckOut();
    }

    private void checkIn() {
        if (library.checkedIn(consoleInput.takeInput()))
            display.displaySuccessfulReturn();
        else
            display.displayUnSuccessfulReturn();
    }
}
