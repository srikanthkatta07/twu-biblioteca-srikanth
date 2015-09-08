//showing the list of option available to the user
package com.twu.biblioteca;

import java.util.ArrayList;

public class MainMenu {

    private Display display;
    private ArrayList<String> menuList;
    private ConsoleInput consoleInput;

    public MainMenu(ArrayList<String> menuList, Display display, ConsoleInput consoleInput) {
        this.menuList = menuList;
        this.display = display;
        this.consoleInput = consoleInput;
    }

    public void showMenuList() {
        for (String options : menuList)
            System.out.println(options);
    }

    public void selectOption(String option) {
        if (option.equals("1"))
            display.displayBookList();
        else if (option.equals("Quit"))
            display.exitMenu();
        else
            display.displayInvalidCommand();
    }
}
