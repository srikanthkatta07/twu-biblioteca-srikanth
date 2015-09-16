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
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(consoleInput);
        bibliotecaApplication.start();
    }

    public void start() {

            LibraryFactory libraryFactory = new LibraryFactory();
            Library library = libraryFactory.setUp();
            Display display = new Display(library);
            StartMenu startMenu = new StartMenu();
            display.displayMessage("Welcome to Biblioteca");
            while (true) {
                startMenu.showStartMenuList();
                UserFactory userFactory = new UserFactory();
                MenuFactory menuFactory = new MenuFactory();
                ArrayList<String> menuList = menuFactory.setUp();
                MainMenu mainMenu = new MainMenu(menuList);
                LoginAuthenticator loginAuthenticator = new LoginAuthenticator(userFactory.setUp());
                Controller controller = new Controller(display, new ConsoleInput(), library, startMenu);
                StartMenuController startMenuController = new StartMenuController(consoleInput, loginAuthenticator, mainMenu, controller);
                startMenuController.delegate(consoleInput.takeInput());
            }
        }
}

