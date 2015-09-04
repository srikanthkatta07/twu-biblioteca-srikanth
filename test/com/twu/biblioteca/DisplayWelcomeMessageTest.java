package com.twu.biblioteca;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class DisplayWelcomeMessageTest {

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
    public void shouldDisplayWelcomeMessage() {
        DisplayWelcomeMessage welcomeMessage = new DisplayWelcomeMessage("Welcome to Biblioteca");

        welcomeMessage.displayMessage();

        assertEquals("Welcome to Biblioteca\n", outContent.toString());
    }
}
