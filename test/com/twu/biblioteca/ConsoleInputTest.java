package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class ConsoleInputTest {

    @Test
    public void takeInputStringFromTheUser() {
        ConsoleInput consoleInput = new ConsoleInput();
        String input = "2";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        assertEquals("2", consoleInput.takeInput());
    }
}
