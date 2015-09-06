package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MainMenuTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ArrayList<String> menuList;
    private Display bookList;

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
        bookList = mock(Display.class);
        menuList.add("1.ListOfBooks");
    }

    @Test
    public void shouldDisplayListOfAvailableOptionsToTheUser() {

        MainMenu mainMenu = new MainMenu(menuList, bookList);

        mainMenu.showMenuList();

        assertEquals("1.ListOfBooks\n", outContent.toString());
    }

    @Test
    public void shouldDisplayListOfBooksWhenUserSelectedOptioOne() {

        MainMenu mainMenu = new MainMenu(menuList, bookList);

        mainMenu.selectOption("1");

        verify(bookList, times(1)).displayBookList();
    }

    @Test
    public void shouldDisplayInvalidMessageWhenUserEntersInvalidOption() {

        MainMenu mainMenu = new MainMenu(menuList, bookList);

        mainMenu.selectOption("4");

        verify(bookList, times(1)).displayInvalidCommand();
    }

    @Test
    public void shouldExitFromTheMenuWhenUserEntersQuitOption() {

        MainMenu mainMenu = new MainMenu(menuList, bookList);

        mainMenu.selectOption("Quit");

        verify(bookList, times(1)).exitMenu();
    }
}
