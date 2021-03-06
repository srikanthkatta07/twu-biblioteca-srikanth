package com.twu.biblioteca;

import org.junit.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.mockito.Mockito.*;

public class BibliotecaApplicationTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldSetUpLibraryAndMenuList() {
        exit.expectSystemExit();

        ConsoleInput consoleInput = mock(ConsoleInput.class);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(consoleInput);

        when(consoleInput.takeInput()).thenReturn("3");

        bibliotecaApplication.start();
    }
}
