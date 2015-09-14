//application which setup the library and menu list
package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApplication {

    private ConsoleInput consoleInput;

    public BibliotecaApplication(ConsoleInput consoleInput) {
        this.consoleInput = consoleInput;
    }

    public static void main(String args[]) {
        ConsoleInput consoleInput = new ConsoleInput();
        Library library = new Library(new ArrayList<Book>(), new ArrayList<Movie>());
        Display display = new Display(library);
        Controller controller = new Controller(display, consoleInput, library);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(consoleInput);
        bibliotecaApplication.start();
    }

    public void start() {
        MenuFactory menuFactory = new MenuFactory();
        LibraryFactory libraryFactory = new LibraryFactory();
        ArrayList<String> menuList = menuFactory.setUp();
        Library library = libraryFactory.setUp();
        Display display = new Display(library);
        display.displayMessage("Welcome to Biblioteca");
        MainMenu mainMenu = new MainMenu(menuList);
        mainMenu.showMenuList();
        Controller controller = new Controller(display, new ConsoleInput(), library);
        while (true) {
            controller.delegate(consoleInput.takeInput());
        }
    }
}
