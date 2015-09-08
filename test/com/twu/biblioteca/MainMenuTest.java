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
    private ArrayList<String> menuList;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }

    @Before
    public void intialSetUp() {
        menuList = new ArrayList<String>();
        menuList.add("1.ListOfBooks");
    }

    @Test
    public void shouldDisplayListOfAvailableOptionsToTheUser() {

        MainMenu mainMenu = new MainMenu(menuList);

        mainMenu.showMenuList();

        assertEquals("1.ListOfBooks\n", outContent.toString());
    }

}
