package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
        ArrayList<String> menuList = new ArrayList<String>();
        DisplayBookList bookList = mock(DisplayBookList.class);

        menuList.add("1.ListOfBooks");

        MainMenu mainMenu = new MainMenu(menuList, bookList);

        mainMenu.showMenuList();

        assertEquals("1.ListOfBooks\n", outContent.toString());
    }

    @Test
    public void shouldDisplayListOfBooksWhenUserSelectedOptioOne() {
        DisplayBookList bookList = mock(DisplayBookList.class);
        ArrayList<String> menuList = new ArrayList<String>();

        menuList.add("1.ListOfBooks");

        MainMenu mainMenu = new MainMenu(menuList, bookList);

        mainMenu.selectOption("1");

        verify(bookList, times(1)).displayBookList();
    }

    @Test
    public void shouldDisplayInvalidMessageWhenUserEntersInvalidOption() {
        DisplayBookList bookList = mock(DisplayBookList.class);
        ArrayList<String> menuList = new ArrayList<String>();

        menuList.add("1.ListOfBooks");

        MainMenu mainMenu = new MainMenu(menuList, bookList);

        mainMenu.selectOption("4");

        verify(bookList, times(1)).displayInvalidCommand();
    }
}
