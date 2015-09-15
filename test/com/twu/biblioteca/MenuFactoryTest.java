package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MenuFactoryTest {

    @Test
    public void shouldEqualsAnotherMenuWhichHasSameMenuList() {
        MenuFactory menuFactory = new MenuFactory();
        ArrayList<String> menuList = new ArrayList<String>();

        menuList.add("1.List of books");
        menuList.add("2.Checkedout books");
        menuList.add("3.Checkedin books");
        menuList.add("4.Quit");
        menuList.add("5.List of Movies");
        menuList.add("6.Checkedout movies");

        assertEquals(menuFactory.setUp(), menuList);
    }
}
