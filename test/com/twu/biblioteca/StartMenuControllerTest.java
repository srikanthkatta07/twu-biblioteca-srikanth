package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class StartMenuControllerTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

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
       StartMenuController startMenuController=new StartMenuController(consoleInput,loginAuthenticator,mainMenu,controller);
        exit.expectSystemExit();
        startMenuController.delegate("3");



    }

}
