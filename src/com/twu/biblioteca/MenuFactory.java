//Which set up list of menu options
package com.twu.biblioteca;

import java.util.ArrayList;

public class MenuFactory {

    ArrayList<String> menuList = new ArrayList<>();

    public ArrayList setUp() {
        menuList.add("1.List of books");
        menuList.add("2.List of Movies");
        menuList.add("3.Checkedout Movies");
        menuList.add("4.Logout");
        return menuList;
    }
}