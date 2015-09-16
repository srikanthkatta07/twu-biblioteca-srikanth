package com.twu.biblioteca;

import java.util.ArrayList;

public class MenuAdder {
    private User user;
    private ArrayList<String> menuList = new ArrayList<String>();

    public MenuAdder(User user) {
        this.user = user;
    }

    public ArrayList<String> addMenuItem() {
        menuList.add("1.List of books");
        menuList.add("2.List of Movies");
        menuList.add("3.Checkedout Movies");
        menuList.add("4.Quit");
        menuList.add("5.Checkedout Books");
        menuList.add("6.Checkedin Books");
        menuList.add("7.User details");
        menuList.add("8.Logout");
        return menuList;
    }
}
