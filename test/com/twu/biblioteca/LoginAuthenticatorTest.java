package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class LoginAuthenticatorTest {

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
    public void shouldReturnTheUserDetailsIfLoginSuccessful() {
        LoginAuthenticator loginAuthenticator = new LoginAuthenticator("123-0007", "srikanth");

        loginAuthenticator.verifyLoginCredentials();

        assertEquals("srikanth\n", outContent.toString());
    }
}
