package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
