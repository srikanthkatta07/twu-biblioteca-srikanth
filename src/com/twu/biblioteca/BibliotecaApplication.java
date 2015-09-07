//application which interacts with the user
package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApplication {

    private ArrayList<Book> listOfBooks;
    private ArrayList<String> menuList;

    public static void main(String args[]) {
        BibliotecaApplication application = new BibliotecaApplication();
        LibrarySetUp libraySetUp = new LibrarySetUp(application.menuList, application.listOfBooks);
        application.librarySetUp(libraySetUp);
        Display display = new Display(application.listOfBooks);
        MainMenu mainMenu = new MainMenu(application.menuList, display);
        display.displayMessage("Welcome to Biblioteca");
        mainMenu.showMenuList();
        String option;
        while (true) {
            Scanner input = new Scanner(System.in);
            option = input.nextLine();
            mainMenu.selectOption(option);
        }
    }

    public void librarySetUp(LibrarySetUp librarySetUp) {

        librarySetUp.setUp();
    }
}
