package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class StartMenuControllerTest {

    @Test
    public void shouldDelegateToTheUserLoginWhenUserEntersOptionLogin() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        LoginAuthenticator loginAuthenticator = mock(LoginAuthenticator.class);
        StartMenuController startMenuController = new StartMenuController(consoleInput, loginAuthenticator);

        startMenuController.delegate("1");

        verify(loginAuthenticator, times(1)).authenticate(null,null);
    }

}
