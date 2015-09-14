//Initializing the list of menu options
package com.twu.biblioteca;

import java.util.ArrayList;

public class MenuFactory {

    ArrayList<String> menuList = new ArrayList<>();

    public ArrayList setUp() {
        menuList.add("1.List of books");
        menuList.add("2.Checkedout books");
        menuList.add("3.Checkedin books");
        menuList.add("4.Quit");
        menuList.add("5.List of Movies");
        return menuList;
    }
}
