//application which interacts with the user
package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApplication {

    private Library library;
    private ArrayList<String> menuList;

    public static void main(String args[]) {
        BibliotecaApplication application = new BibliotecaApplication();
        application.librarySetUp();
        ConsoleInput consoleInput = new ConsoleInput();
        Display display = new Display(application.library);
        Controller controller = new Controller(display, consoleInput, application.library);
        MainMenu mainMenu = new MainMenu(application.menuList);
        display.displayMessage("Welcome to Biblioteca");
        mainMenu.showMenuList();
        while (true) {
            controller.delegate(consoleInput.takeInput());
        }
    }

    public void librarySetUp() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book book1 = new Book("TWOSTATES", "CHETAN", 2008);
        Book book2 = new Book("WINGSOFFIRE", "APJ", 2007);
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        library = new Library(listOfBooks);
        menuList = new ArrayList<String>();
        menuList.add("1.List of books");
        menuList.add("2.Checkedout books");
        menuList.add("3.Checkedin books");
        menuList.add("4.Quit");
    }
}
