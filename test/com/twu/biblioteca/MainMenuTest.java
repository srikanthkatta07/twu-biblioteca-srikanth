package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MainMenuTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }

    @Test
    public void shouldDisplayListOfAvailableOptionsToTheUser() {
        ArrayList<String> menuList=new ArrayList<String>();

        menuList.add("1.ListOfBooks");

        MainMenu mainMenu = new MainMenu(menuList);

        mainMenu.showMenuList();

        assertEquals("1.ListOfBooks\n", outContent.toString());
    }
}
