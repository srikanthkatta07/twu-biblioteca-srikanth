package com.twu.biblioteca;

import org.junit.*;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class ControllerTest {

    private ConsoleInput consoleInput;
    private Library library;
    private ArrayList<Book> listOfBooks;
    private ArrayList<Movie> movies;
    private User user;
    private StartMenu startMenu;

    @Before
    public void setUp() {
        consoleInput = new ConsoleInput();
        user = mock(User.class);
        listOfBooks = new ArrayList<Book>();
        movies = new ArrayList<Movie>();
        library = new Library(listOfBooks, movies);
        startMenu = mock(StartMenu.class);
    }

    @Test
    public void shouldDelgateToTheDisplayingBookListIfUserEnterOptionOne() {
        Display display = mock(Display.class);
        Controller controller = new Controller(display, consoleInput, library, startMenu);

        controller.delegate("1", user);

        verify(display, times(1)).displayBookList();
    }

    @Test
    public void shouldDelegateTheDisplayingListOfMoviesWhenUserEntersOptionTwo() {
        Display display = mock(Display.class);
        Controller controller = new Controller(display, consoleInput, library, startMenu);

        controller.delegate("2", user);

        verify(display, times(1)).displayMovieList();
    }

    @Test
    public void shouldTakeTheNameOfTheMovieFromTheUserToCheckedOutWhenUserEnterOptionThree() {
        Display display = mock(Display.class);
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        Controller controller = new Controller(display, consoleInput, library, startMenu);

        controller.delegate("3", user);

        verify(consoleInput, times(1)).takeInput();
    }


    @Test
    public void shouldLogOutFromCurrentSessionWhenUserEnterTheOptionFour() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        Library library = mock(Library.class);
        Display display = mock(Display.class);
        User user = new User("123-777", "abcd", "srikanth", "9666837099", "s@gmail.com", "user");
        Controller controller = new Controller(display, consoleInput, library, startMenu);

        controller.delegate("4", user);

    }


    @Test
    public void shouldTakeTheNameOfTheBookFromTheUserToCheckedOutWhenUserEntersOptionFive() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        Display display = mock(Display.class);
        User user = new User("default", "default", "default", "default", "default", "user");
        Controller controller = new Controller(display, consoleInput, library, startMenu);

        controller.delegate("5", user);

        verify(consoleInput, times(1)).takeInput();
    }

    @Test
    public void shouldTakeTheNameOfTheBookFromTheUserToCheckedInWhenUserEntersOptionSix() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        Display display = mock(Display.class);
        User user = new User("default", "default", "default", "default", "default", "user");
        Controller controller = new Controller(display, consoleInput, library, startMenu);

        controller.delegate("6", user);

        verify(consoleInput, times(1)).takeInput();
    }

    @Test
    public void shouldDelegateToDisplayTheUserDetailsWhenUserEnterOptionSeven() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        Library library = mock(Library.class);
        Display display = mock(Display.class);
        User user = new User("123-777", "abcd", "srikanth", "9666837099", "s@gmail.com", "user");
        Controller controller = new Controller(display, consoleInput, library, startMenu);

        controller.delegate("7", user);

        verify(display).displayMessage(String.format("%-20S%-20S%-20S%-20S", "srikanth", "9666837099", "s@gmail.com", "user"));
    }

    @Test
    public void shouldDelegateToDisplayInvalidMessageWhenUserEnterInvalidOption() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        Library library = mock(Library.class);
        Display display = mock(Display.class);
        User user = new User("123-777", "abcd", "srikanth", "9666837099", "s@gmail.com", "user");
        Controller controller = new Controller(display, consoleInput, library, startMenu);

        controller.delegate("9", user);

        verify(display).displayInvalidOptionMessage();
    }

    @Test
    public void shouldDelegateToLibraryToDisplayTheListOfCheckedOutUsers() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        Library library = mock(Library.class);
        Display display = mock(Display.class);
        User user = new User("123-777", "abcd", "srikanth", "9666837099", "s@gmail.com", "librarian");
        Controller controller = new Controller(display, consoleInput, library, startMenu);

        controller.delegate("8", user);

        verify(library).getCheckedOutUsers();
    }
}
