//showing the list of option available to the user
package com.twu.biblioteca;

import java.util.ArrayList;

public class MainMenu {

    private ArrayList<String> menuList;

    public MainMenu(ArrayList<String> menuList) {
        this.menuList = menuList;
    }

    public void showMenuList() {
        for (String options : menuList)
            System.out.println(options);
    }
}
