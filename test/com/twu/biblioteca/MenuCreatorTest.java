package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MenuCreatorTest {

    @Test
    public void shouldCreateTheNewMenuListIfNormalUserLoggedIn() {
        ArrayList<String> menuList = new ArrayList<String>();
        User user =new User("default","default","default","default","default","user");
        MenuCreator menuAdder = new MenuCreator(user);

        menuList.add("1.List of books");
        menuList.add("2.List of Movies");
        menuList.add("3.Checkedout Movies");
        menuList.add("4.Logout");
        menuList.add("5.Checkedout Books");
        menuList.add("6.Checkedin Books");
        menuList.add("7.User details");

        assertEquals(menuList, menuAdder.addMenuItem());
    }

    @Test
    public void shouldCreateTheNewMenuListIfLibrarianLoggedIn() {
        ArrayList<String> menuList = new ArrayList<String>();
        User user =new User("default","default","default","default","default","librarian");
        MenuCreator menuAdder = new MenuCreator(user);

        menuList.add("1.List of books");
        menuList.add("2.List of Movies");
        menuList.add("3.Checkedout Movies");
        menuList.add("4.Logout");
        menuList.add("5.Checkedout Books");
        menuList.add("6.Checkedin Books");
        menuList.add("7.User details");
        menuList.add("8.Checkedout Booklist");

        assertEquals(menuList, menuAdder.addMenuItem());
    }
}
