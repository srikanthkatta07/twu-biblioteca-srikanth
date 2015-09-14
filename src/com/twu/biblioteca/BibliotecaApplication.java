//application which interacts with the user
package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApplication {

    public static void main(String args[]) {
        BibliotecaApplication application = new BibliotecaApplication();
        MenuFactory menuFactory = new MenuFactory();
        ArrayList<String> menuList = menuFactory.setUp();
        LibraryFactory libraryFactory = new LibraryFactory();
        Library library = libraryFactory.setUp();
        ConsoleInput consoleInput = new ConsoleInput();
        Display display = new Display(library);
        Controller controller = new Controller(display, consoleInput, library);
        MainMenu mainMenu = new MainMenu(menuList);
        display.displayMessage("Welcome to Biblioteca");
        mainMenu.showMenuList();
        while (true) {
            controller.delegate(consoleInput.takeInput());
        }
    }
}
