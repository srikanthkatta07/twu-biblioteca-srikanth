package com.twu.biblioteca;

import org.junit.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class LoginMenuControllerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldDelegateToTheUserLoginWhenUserEntersOptionLogin() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        LoginAuthenticator loginAuthenticator = mock(LoginAuthenticator.class);
        MainMenu mainMenu = mock(MainMenu.class);
        OptionController optionController = mock(OptionController.class);
        LoginMenuController loginMenuController = new LoginMenuController(consoleInput, loginAuthenticator, mainMenu, optionController);

        loginMenuController.delegate("1");

        verify(loginAuthenticator, times(1)).authenticate(null, null);
    }

    @Test
    public void shouldDelegateToMainControllerOptionWhenUserEntersAsGuestOption() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        LoginAuthenticator loginAuthenticator = mock(LoginAuthenticator.class);
        MainMenu mainMenu = mock(MainMenu.class);
        OptionController optionController = mock(OptionController.class);
        LoginMenuController loginMenuController = new LoginMenuController(consoleInput, loginAuthenticator, mainMenu, optionController);

        when(consoleInput.takeInput()).thenReturn("4");
        loginMenuController.delegate("2");

        verify(mainMenu, times(1)).showMenuList();
    }

    @Test
    public void shouldQuitWhenUsersEntersQuitOption() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        LoginAuthenticator loginAuthenticator = mock(LoginAuthenticator.class);
        MainMenu mainMenu = mock(MainMenu.class);
        OptionController optionController = mock(OptionController.class);
        LoginMenuController loginMenuController = new LoginMenuController(consoleInput, loginAuthenticator, mainMenu, optionController);

        exit.expectSystemExit();

        loginMenuController.delegate("3");
    }

    @Test
    public void shouldDisplayInvalidLoginOptionIfUserEntersWrongCredentials() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        LoginAuthenticator loginAuthenticator = mock(LoginAuthenticator.class);
        MainMenu mainMenu = mock(MainMenu.class);
        OptionController optionController = mock(OptionController.class);
        LoginMenuController loginMenuController = new LoginMenuController(consoleInput, loginAuthenticator, mainMenu, optionController);

        when(loginAuthenticator.authenticate("abc", "abc")).thenReturn(null);
        loginMenuController.delegate("1");

        assertEquals("Please provide valid details\n", outContent.toString());
    }


}
