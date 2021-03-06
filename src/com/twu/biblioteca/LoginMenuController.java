//Controller for delegating the login menu options
package com.twu.biblioteca;

public class LoginMenuController {

    private MainMenu mainMenu;
    private OptionController optionController;
    private LoginAuthenticator loginAuthenticator;
    private ConsoleInput consoleInput;
    private User user;
    private MenuCreator menuCreator;

    public LoginMenuController(ConsoleInput consoleInput, LoginAuthenticator loginAuthenticator, MainMenu mainMenu, OptionController optionController) {
        this.consoleInput = consoleInput;
        this.loginAuthenticator = loginAuthenticator;
        this.mainMenu = mainMenu;
        this.optionController = optionController;
    }

    public void delegate(String option) {
        if (option.equals("1")) {
            System.out.println("Enter the library number:");
            String libraryNumber = consoleInput.takeInput();
            System.out.println("Enter the password:");
            String password = consoleInput.takeInput();
            user = loginAuthenticator.authenticate(libraryNumber, password);
            if (user != null) {
                System.out.println("Sucessfully Logged In");
                menuCreator = new MenuCreator(user);
                mainMenu = new MainMenu(menuCreator.addMenuItem());
                mainMenu.showMenuList();
                while (true) {
                    String input = consoleInput.takeInput();
                    if (input.equals("4")) {
                        System.out.println("Sucessfully Logged out");
                        break;
                    } else
                        optionController.delegate(input, user);
                }
            } else {
                System.out.println("Please provide valid details");
            }
        } else if (option.equals("2")) {
            System.out.println("Sucessfully Logged In");
            mainMenu.showMenuList();
            user = new User("default", "default", "default", "default", "default", "default");
            while (true) {
                String input = consoleInput.takeInput();
                if (input.equals("4")) {
                    System.out.println("Sucessfully Logged out");
                    break;
                } else
                    optionController.delegate(input, user);
            }
        } else if (option.equals("3")) {
            System.exit(0);
        } else {
            System.out.println("Enter valid option");
        }
    }
}
