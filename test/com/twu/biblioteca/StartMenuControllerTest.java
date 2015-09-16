package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class StartMenuControllerTest {

    @Test
    public void shouldDelegateToTheUserLoginWhenUserEntersOptionLogin() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        LoginAuthenticator loginAuthenticator = mock(LoginAuthenticator.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Controller controller = mock(Controller.class);
        StartMenuController startMenuController = new StartMenuController(consoleInput, loginAuthenticator, mainMenu,controller);

        startMenuController.delegate("1");

        verify(loginAuthenticator, times(1)).authenticate(null, null);
    }

    @Test
    public void shouldDelegateToMainControllerOptionWhenUserEntersAsGuestOption() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        LoginAuthenticator loginAuthenticator = mock(LoginAuthenticator.class);
        MainMenu mainMenu = mock(MainMenu.class);
        Controller controller = mock(Controller.class);
        StartMenuController startMenuController = new StartMenuController(consoleInput, loginAuthenticator, mainMenu,controller);

        startMenuController.delegate("2");

        verify(mainMenu, times(1)).showMenuList();
    }

}
