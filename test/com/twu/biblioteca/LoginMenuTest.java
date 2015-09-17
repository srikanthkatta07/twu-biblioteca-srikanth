package com.twu.biblioteca;

import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class LoginMenuTest {

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

        LoginMenu loginMenu = new LoginMenu();

        loginMenu.showLoginMenuList();

        assertEquals("1.LogIn\n2.As Guest\n3.Quit\n", outContent.toString());
    }
}
