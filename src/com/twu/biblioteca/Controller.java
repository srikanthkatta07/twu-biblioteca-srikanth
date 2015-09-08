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
        else if (option.equals("2")) {
            library.checkedOut(consoleInput.takeInput());
        } else if (option.equals("Quit"))
            display.exitMenu();

        else
            display.displayInvalidCommand();

    }
}
