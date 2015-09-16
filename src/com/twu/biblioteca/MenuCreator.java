//creation of menu lists based on user or librarian
package com.twu.biblioteca;

import java.util.ArrayList;

public class MenuCreator {

    private User user;
    private ArrayList<String> menuList = new ArrayList<String>();

    public MenuCreator(User user) {
        this.user = user;
    }

    public ArrayList<String> addMenuItem() {
        if ((user.getRole()).equals("user")) {
            menuList.add("1.List of books");
            menuList.add("2.List of Movies");
            menuList.add("3.Checkedout Movies");
            menuList.add("4.Logout");
            menuList.add("5.Checkedout Books");
            menuList.add("6.Checkedin Books");
            menuList.add("7.User details");
            return menuList;
        } else {
            menuList.add("1.List of books");
            menuList.add("2.List of Movies");
            menuList.add("3.Checkedout Movies");
            menuList.add("4.Logout");
            menuList.add("5.Checkedout Books");
            menuList.add("6.Checkedin Books");
            menuList.add("7.User details");
            menuList.add("8.Checkedout Booklist");
            return menuList;
        }
    }
}
