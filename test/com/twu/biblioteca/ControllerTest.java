package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class ControllerTest {

    @Test
    public void shouldDelgateToTheDisplayingBookListIfUserEnterOptionOne() {
        Display display = mock(Display.class);
        Controller controller = new Controller(display);

        controller.delegate("1");

        verify(display, times(1)).displayBookList();
    }

    @Test
    public void shouldDisplayInvalidMessageWhenUserEntersInvalidOption() {
        Display display = mock(Display.class);
        Controller controller = new Controller(display);

        controller.delegate("abcd");

        verify(display, times(1)).displayInvalidCommand();
    }

    @Test
    public void shouldExitFromTheMenuWhenUserEntersQuitOption() {
        Display display = mock(Display.class);
        Controller controller = new Controller(display);

        controller.delegate("Quit");

        verify(display, times(1)).exitMenu();
    }

}
