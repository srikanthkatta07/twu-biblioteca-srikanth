package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MenuFactoryTest {

    @Test
    public void shouldEqualsAnotherMenuWhichHasSameMenuList() {
        MenuFactory menuFactory = new MenuFactory();
        ArrayList<String> menuList = new ArrayList<>();

        menuList = new ArrayList<String>();
        menuList.add("1.List of books");
        menuList.add("2.Checkedout books");
        menuList.add("3.Checkedin books");
        menuList.add("4.Quit");

        assertEquals(menuFactory.setUp(), menuList);
    }

}
