package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class BibliotecaApplicationTest {

    @Test
    public void shouldSetUpListOfBooksAndMenuListBeforeApplicationStarts() {
        BibliotecaApplication bibliotecaApplication = mock(BibliotecaApplication.class);

        bibliotecaApplication.setUpMenuList();

        verify(bibliotecaApplication, times(1)).setUpMenuList();
    }
}
