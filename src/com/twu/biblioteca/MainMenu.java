//showing the list of option available to the user
package com.twu.biblioteca;

import java.util.ArrayList;

public class MainMenu {
    private Display bookList;
    ArrayList<String> menuList;

    public MainMenu(ArrayList<String> menuList, Display bookList) {
        this.menuList = menuList;
        this.bookList = bookList;
    }

    public void showMenuList() {
        for (String options : menuList)
            System.out.println(options);
    }

    public void selectOption(String option) {
        if (option.equals("1"))
            bookList.displayBookList();
        else if (option.equals("Quit"))
            bookList.exitMenu();
        else
            bookList.displayInvalidCommand();
    }
}
