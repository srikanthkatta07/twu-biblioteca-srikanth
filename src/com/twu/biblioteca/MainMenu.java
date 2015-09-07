//showing the list of option available to the user
package com.twu.biblioteca;

import java.util.ArrayList;

public class MainMenu {

    private Display display;
    private ArrayList<String> menuList;

    public MainMenu(ArrayList<String> menuList, Display display) {
        this.menuList = menuList;
        this.display = display;
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
