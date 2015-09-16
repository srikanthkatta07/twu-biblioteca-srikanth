package com.twu.biblioteca;

public class StartMenuController {

    private final MainMenu mainMenu;
    private final Controller controller;
    private LoginAuthenticator loginAuthenticator;
    private ConsoleInput consoleInput;

    public StartMenuController(ConsoleInput consoleInput, LoginAuthenticator loginAuthenticator,MainMenu mainMenu,Controller controller) {
        this.consoleInput = consoleInput;
        this.loginAuthenticator = loginAuthenticator;
        this.mainMenu=mainMenu;
        this.controller=controller;
    }

    public void delegate(String option) {
        if(option.equals("1"))
            loginAuthenticator.authenticate(consoleInput.takeInput(), consoleInput.takeInput());
        else {
            mainMenu.showMenuList();
            controller.delegate(consoleInput.takeInput());
        }
    }
}
