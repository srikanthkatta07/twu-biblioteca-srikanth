package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MenuAdderTest {

    @Test
    public void shouldAddTheAdditonalMenuItemsToTheMainMenuIfNormalUserLoggedIn() {
        ArrayList<String> menuList = new ArrayList<String>();
        User user = mock(User.class);
        MenuAdder menuAdder = new MenuAdder(user);

        menuList.add("1.List of books");
        menuList.add("2.List of Movies");
        menuList.add("3.Checkedout Movies");
        menuList.add("4.Quit");
        menuList.add("5.Checkedout Books");
        menuList.add("6.Checkedin Books");
        menuList.add("7.User details");
        menuList.add("8.Logout");

        assertEquals(menuList, menuAdder.addMenuItem());
    }
}
