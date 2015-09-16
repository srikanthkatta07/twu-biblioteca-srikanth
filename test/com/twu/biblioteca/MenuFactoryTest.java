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
        menuList.add("2.List of Movies");
        menuList.add("3.Checkedout Movies");
        menuList.add("4.Logout");

        assertEquals(menuList, menuFactory.setUp());
    }
}
