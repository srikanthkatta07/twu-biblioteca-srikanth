//application which interacts with the user
package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApplication {

    private ArrayList<String> menuList;

    public static void main(String args[]) {
        BibliotecaApplication application = new BibliotecaApplication();
        application.setUpMenuList();
        LibraryFactory libraryFactory = new LibraryFactory();
        Library library = libraryFactory.setUp();
        ConsoleInput consoleInput = new ConsoleInput();
        Display display = new Display(library);
        Controller controller = new Controller(display, consoleInput, library);
        MainMenu mainMenu = new MainMenu(application.menuList);
        display.displayMessage("Welcome to Biblioteca");
        mainMenu.showMenuList();
        while (true) {
            controller.delegate(consoleInput.takeInput());
        }
    }

    public void setUpMenuList() {
        menuList = new ArrayList<String>();
        menuList.add("1.List of books");
        menuList.add("2.Checkedout books");
        menuList.add("3.Checkedin books");
        menuList.add("4.Quit");
    }
}
