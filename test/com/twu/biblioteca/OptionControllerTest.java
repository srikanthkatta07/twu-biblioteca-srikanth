package com.twu.biblioteca;

import org.junit.*;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class OptionControllerTest {

    private ConsoleInput consoleInput;
    private Library library;
    private ArrayList<Book> listOfBooks;
    private ArrayList<Movie> movies;
    private User user;
    private LoginMenu loginMenu;

    @Before
    public void setUp() {
        consoleInput = new ConsoleInput();
        user = mock(User.class);
        listOfBooks = new ArrayList<Book>();
        movies = new ArrayList<Movie>();
        library = new Library(listOfBooks, movies);
        loginMenu = mock(LoginMenu.class);
    }

    @Test
    public void shouldDelgateToTheDisplayingBookListIfUserEnterOptionOne() {
        Display display = mock(Display.class);
        OptionController optionController = new OptionController(display, consoleInput, library, loginMenu);

        optionController.delegate("1", user);

        verify(display, times(1)).displayBookList();
    }

    @Test
    public void shouldDelegateTheDisplayingListOfMoviesWhenUserEntersOptionTwo() {
        Display display = mock(Display.class);
        OptionController optionController = new OptionController(display, consoleInput, library, loginMenu);

        optionController.delegate("2", user);

        verify(display, times(1)).displayMovieList();
    }

    @Test
    public void shouldTakeTheNameOfTheMovieFromTheUserToCheckedOutWhenUserEnterOptionThree() {
        Display display = mock(Display.class);
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        OptionController optionController = new OptionController(display, consoleInput, library, loginMenu);

        optionController.delegate("3", user);

        verify(consoleInput, times(1)).takeInput();
    }


    @Test
    public void shouldLogOutFromCurrentSessionWhenUserEnterTheOptionFour() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        Library library = mock(Library.class);
        Display display = mock(Display.class);
        User user = new User("123-777", "abcd", "srikanth", "9666837099", "s@gmail.com", "user");
        OptionController optionController = new OptionController(display, consoleInput, library, loginMenu);

        optionController.delegate("4", user);

    }


    @Test
    public void shouldTakeTheNameOfTheBookFromTheUserToCheckedOutWhenUserEntersOptionFive() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        Display display = mock(Display.class);
        User user = new User("default", "default", "default", "default", "default", "user");
        OptionController optionController = new OptionController(display, consoleInput, library, loginMenu);

        optionController.delegate("5", user);

        verify(consoleInput, times(1)).takeInput();
    }

    @Test
    public void shouldTakeTheNameOfTheBookFromTheUserToCheckedInWhenUserEntersOptionSix() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        Display display = mock(Display.class);
        User user = new User("default", "default", "default", "default", "default", "user");
        OptionController optionController = new OptionController(display, consoleInput, library, loginMenu);

        optionController.delegate("6", user);

        verify(consoleInput, times(1)).takeInput();
    }

    @Test
    public void shouldDelegateToDisplayTheUserDetailsWhenUserEnterOptionSeven() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        Library library = mock(Library.class);
        Display display = mock(Display.class);
        User user = new User("123-777", "abcd", "srikanth", "9666837099", "s@gmail.com", "user");
        OptionController optionController = new OptionController(display, consoleInput, library, loginMenu);

        optionController.delegate("7", user);

        verify(display).displayMessage(String.format("%-20S%-20S%-20S%-20S", "srikanth", "9666837099", "s@gmail.com", "user"));
    }

    @Test
    public void shouldDelegateToDisplayInvalidMessageWhenUserEnterInvalidOption() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        Library library = mock(Library.class);
        Display display = mock(Display.class);
        User user = new User("123-777", "abcd", "srikanth", "9666837099", "s@gmail.com", "user");
        OptionController optionController = new OptionController(display, consoleInput, library, loginMenu);

        optionController.delegate("9", user);

        verify(display).displayInvalidOptionMessage();
    }

    @Test
    public void shouldDelegateToLibraryToDisplayTheListOfCheckedOutUsers() {
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        Library library = mock(Library.class);
        Display display = mock(Display.class);
        User user = new User("123-777", "abcd", "srikanth", "9666837099", "s@gmail.com", "librarian");
        OptionController optionController = new OptionController(display, consoleInput, library, loginMenu);

        optionController.delegate("8", user);

        verify(library).getCheckedOutUsers();
    }
}
