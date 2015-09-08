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
    private Display display;
    private ConsoleInput consoleInput;

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
        consoleInput=mock(ConsoleInput.class);
        display = mock(Display.class);
        menuList.add("1.ListOfBooks");
    }

    @Test
    public void shouldDisplayListOfAvailableOptionsToTheUser() {

        MainMenu mainMenu = new MainMenu(menuList, display,consoleInput);

        mainMenu.showMenuList();

        assertEquals("1.ListOfBooks\n", outContent.toString());
    }

    @Test
    public void shouldDisplayListOfBooksWhenUserSelectedOptioOne() {

        MainMenu mainMenu = new MainMenu(menuList, display,consoleInput);

        mainMenu.selectOption("1");

        verify(display, times(1)).displayBookList();
    }

    @Test
    public void shouldDisplayInvalidMessageWhenUserEntersInvalidOption() {

        MainMenu mainMenu = new MainMenu(menuList, display,consoleInput);

        mainMenu.selectOption("4");

        verify(display, times(1)).displayInvalidCommand();
    }

    @Test
    public void shouldExitFromTheMenuWhenUserEntersQuitOption() {

        MainMenu mainMenu = new MainMenu(menuList, display,consoleInput);

        mainMenu.selectOption("Quit");

        verify(display, times(1)).exitMenu();
    }
}
