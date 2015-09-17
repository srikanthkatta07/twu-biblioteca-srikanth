//which starts the application and setup the library and users,menu lists
package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApplication {

    private ConsoleInput consoleInput;

    public BibliotecaApplication(ConsoleInput consoleInput) {
        this.consoleInput = consoleInput;
    }

    public static void main(String args[]) {
        ConsoleInput consoleInput = new ConsoleInput();
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(consoleInput);
        bibliotecaApplication.start();
    }

    public void start() {
        LibraryFactory libraryFactory = new LibraryFactory();
        Library library = libraryFactory.setUp();
        Display display = new Display(library);
        LoginMenu loginMenu = new LoginMenu();
        display.displayMessage("Welcome to Biblioteca");
        while (true) {
            loginMenu.showLoginMenuList();
            UserFactory userFactory = new UserFactory();
            MenuFactory menuFactory = new MenuFactory();
            ArrayList<String> menuList = menuFactory.setUp();
            MainMenu mainMenu = new MainMenu(menuList);
            LoginAuthenticator loginAuthenticator = new LoginAuthenticator(userFactory.setUp());
            OptionController optionController = new OptionController(display, new ConsoleInput(), library, loginMenu);
            LoginMenuController loginMenuController = new LoginMenuController(consoleInput, loginAuthenticator, mainMenu, optionController);
            loginMenuController.delegate(consoleInput.takeInput());
        }
    }
}

