package com.twu.biblioteca;

public class StartMenuController {

    private MainMenu mainMenu;
    private Controller controller;
    private LoginAuthenticator loginAuthenticator;
    private ConsoleInput consoleInput;
    private User user;
    private MenuCreator menuCreator;

    public StartMenuController(ConsoleInput consoleInput, LoginAuthenticator loginAuthenticator, MainMenu mainMenu, Controller controller) {
        this.consoleInput = consoleInput;
        this.loginAuthenticator = loginAuthenticator;
        this.mainMenu = mainMenu;
        this.controller = controller;
    }

    public void delegate(String option) {
        if (option.equals("1")) {
            user = loginAuthenticator.authenticate(consoleInput.takeInput(), consoleInput.takeInput());
            if (user != null) {
                menuCreator = new MenuCreator(user);
                mainMenu = new MainMenu(menuCreator.addMenuItem());
                mainMenu.showMenuList();
                while(true) {
                    String input=consoleInput.takeInput();
                    if(input.equals("4"))
                        break;
                    else
                        controller.delegate(input, user);
                }
            }
            else{
                System.out.println("Please provide valid details");
            }
        } else if (option.equals("2")) {
            mainMenu.showMenuList();
            user = new User("default", "default", "default", "default", "default", "default");
            while(true) {
                String input=consoleInput.takeInput();
                if(input.equals("4"))
                    break;
                else
                    controller.delegate(input, user);
            }
        } else {
            System.exit(0);
        }
    }
}
