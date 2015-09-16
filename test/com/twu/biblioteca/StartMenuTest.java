package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class StartMenuTest {
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

        StartMenu startMenu = new StartMenu();

        startMenu.showStartMenuList();

        assertEquals("1.LogIn\n2.As Guest\n3.Quit\n", outContent.toString());
    }
}
