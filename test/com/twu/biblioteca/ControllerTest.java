package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class ControllerTest {

    private ConsoleInput consoleInput;
    private Library library;
    private ArrayList<Book> listOfBooks;

    @Before
    public void setUp() {
        consoleInput = new ConsoleInput();
        listOfBooks = new ArrayList<Book>();
        library = new Library(listOfBooks);
    }

    @Test
    public void shouldDelgateToTheDisplayingBookListIfUserEnterOptionOne() {
        Display display = mock(Display.class);
        Controller controller = new Controller(display, consoleInput, library);

        controller.delegate("1");

        verify(display, times(1)).displayBookList();
    }

    @Test
    public void shouldDisplayInvalidMessageWhenUserEntersInvalidOption() {
        Display display = mock(Display.class);
        Controller controller = new Controller(display, consoleInput, library);

        controller.delegate("abcd");

        verify(display, times(1)).displayInvalidCommand();
    }

    @Test
    public void shouldExitFromTheMenuWhenUserEntersQuitOption() {
        Display display = mock(Display.class);
        Controller controller = new Controller(display, consoleInput, library);

        controller.delegate("4");

        verify(display, times(1)).exitMenu();
    }

    @Test
    public void shouldTakeTheNameOfTheBookFromTheUserToCheckedOutWhenUserEntersOptionTwo() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        Display display = mock(Display.class);
        Controller controller = new Controller(display, consoleInput, library);

        controller.delegate("2");

        verify(consoleInput, times(1)).takeInput();
    }

    @Test
    public void shouldTakeTheNameOfTheBookFromTheUserToCheckedInWhenUserEnterOptionThree() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        Display display = mock(Display.class);
        Controller controller = new Controller(display, consoleInput, library);

        controller.delegate("3");

        verify(consoleInput, times(1)).takeInput();
    }

}
