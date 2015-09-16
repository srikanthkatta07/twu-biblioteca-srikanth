//It delegates the user choices
package com.twu.biblioteca;

public class Controller {

    private StartMenu startMenu;
    private User user;
    private Library library;
    private ConsoleInput consoleInput;
    private Display display;

    public Controller(Display display, ConsoleInput consoleInput, Library library, StartMenu startMenu) {
        this.display = display;
        this.consoleInput = consoleInput;
        this.library = library;
        this.startMenu = startMenu;
    }

    public void delegate(String option, User user) {
        if (option.equals("1"))
            display.displayBookList();
        else if (option.equals("2"))
            display.displayMovieList();
        else if (option.equals("3"))
            checkOutMovie();
        else if (option.equals("4") && ((user.getRole().equals("user")) || (user.getRole().equals("librarian")))) {
            this.user = null;
            startMenu.showStartMenuList();
        } else if (option.equals("5") && ((user.getRole().equals("user")) || (user.getRole().equals("librarian"))))
            checkOut();
        else if (option.equals("6") && ((user.getRole().equals("user")) || (user.getRole().equals("librarian"))))
            checkIn();
        else if (option.equals("7") && ((user.getRole().equals("user")) || (user.getRole().equals("librarian"))))
            display.displayMessage(user.toString());
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
