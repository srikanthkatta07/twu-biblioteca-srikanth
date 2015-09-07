package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class BibliotecaApplicationTest {

    @Test
    public void shouldSetUpListOfBooksBeforeApplicationStarts() {
        LibrarySetUp librarySetUp = mock(LibrarySetUp.class);
        BibliotecaApplication application = new BibliotecaApplication();

        application.librarySetUp(librarySetUp);

        verify(librarySetUp, times(1)).setUp();
    }
}
