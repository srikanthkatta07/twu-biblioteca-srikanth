package com.twu.biblioteca;

public class StartMenuController {

    private LoginAuthenticator loginAuthenticator;
    private ConsoleInput consoleInput;

    public StartMenuController(ConsoleInput consoleInput, LoginAuthenticator loginAuthenticator) {
        this.consoleInput = consoleInput;
        this.loginAuthenticator = loginAuthenticator;
    }

    public void delegate(String option) {
        loginAuthenticator.authenticate(consoleInput.takeInput(), consoleInput.takeInput());
    }
}
