package com.twu.biblioteca;

import org.junit.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class StartMenuControllerTest {

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
        Controller controller = mock(Controller.class);
        StartMenuController startMenuController = new StartMenuController(consoleInput, loginAuthenticator, mainMenu, controller);

        startMenuController.delegate("1");

        verify(loginAuthenticator, times(1)).authenticate(null, null);
    }

    @Test
    public void shouldDelegateToMainControllerOptionWhenUserEntersAsGuestOption() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        LoginAuthenticator loginAuthenticator = mock(LoginAuthenticator.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Controller controller = mock(Controller.class);
        StartMenuController startMenuController = new StartMenuController(consoleInput, loginAuthenticator, mainMenu, controller);

        when(consoleInput.takeInput()).thenReturn("4");
        startMenuController.delegate("2");

        verify(mainMenu, times(1)).showMenuList();
    }

    @Test
    public void shouldQuitWhenUsersEntersQuitOption() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        LoginAuthenticator loginAuthenticator = mock(LoginAuthenticator.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Controller controller = mock(Controller.class);
        StartMenuController startMenuController = new StartMenuController(consoleInput, loginAuthenticator, mainMenu, controller);

        exit.expectSystemExit();

        startMenuController.delegate("3");
    }

    @Test
    public void shouldDisplayInvalidLoginOptionIfUserEntersWrongCredentials() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        LoginAuthenticator loginAuthenticator = mock(LoginAuthenticator.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Controller controller = mock(Controller.class);
        StartMenuController startMenuController = new StartMenuController(consoleInput, loginAuthenticator, mainMenu, controller);

        when(loginAuthenticator.authenticate("abc","abc")).thenReturn(null);
        startMenuController.delegate("1");

        assertEquals("Please provide valid details\n",outContent.toString());
    }


}
