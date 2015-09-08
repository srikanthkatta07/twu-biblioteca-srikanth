package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class ControllerTest {

    @Test
    public void shouldDelgateToTheDisplayingBookListIfUserEnterOptionOne() {
        Display display=mock(Display.class);
        Controller controller=new Controller(display);

        controller.delegate("1");

        verify(display,times(1)).displayBookList();
    }
}
