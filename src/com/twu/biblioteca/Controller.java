//It delegates the choices based on user or librarian or default user
package com.twu.biblioteca;

public class Controller {

    private StartMenu startMenu;
    private Library library;
    private ConsoleInput consoleInput;
    private Display display;
    private User user;

    public Controller(Display display, ConsoleInput consoleInput, Library library, StartMenu startMenu) {
        this.display = display;
        this.consoleInput = consoleInput;
        this.library = library;
        this.startMenu = startMenu;
    }

    public void delegate(String option, User user) {
        this.user = user;
        if (option.equals("1"))
            display.displayBookList();
        else if (option.equals("2"))
            display.displayMovieList();
        else if (option.equals("3"))
            checkOutMovie();
        else if (option.equals("5") && ((user.getRole().equals("user")) || (user.getRole().equals("librarian"))))
            checkOut(this.user);
        else if (option.equals("6") && ((user.getRole().equals("user")) || (user.getRole().equals("librarian"))))
            checkIn(this.user);
        else if (option.equals("7") && ((user.getRole().equals("user")) || (user.getRole().equals("librarian"))))
            display.displayMessage(user.toString());
        else if (option.equals("8") && (user.getRole().equals("librarian")))
            System.out.println(library.getCheckedOutUsers());
        else
            display.displayInvalidOptionMessage();
    }

    private void checkOutMovie() {
        if (library.checkedOutMovie(consoleInput.takeInput()))
            display.displaySuccessfulMovieCheckOut();
        else
            display.displayUnSuccessfulMovieCheckOut();
    }

    private void checkOut(User user) {
        if (library.checkedOut(consoleInput.takeInput(), user))
            display.displaySuccessfulCheckOut();
        else
            display.displayUnSuccessfulCheckOut();
    }

    private void checkIn(User user) {
        if (library.checkedIn(consoleInput.takeInput(), user))
            display.displaySuccessfulReturn();
        else
            display.displayUnSuccessfulReturn();
    }
}
