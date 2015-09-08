//application which interacts with the user
package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApplication {

    private Library library;
    private ArrayList<String> menuList;

    public static void main(String args[]) {
        BibliotecaApplication application = new BibliotecaApplication();
        application.LibraySetUp();
        Display display = new Display(application.library);
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

    private void LibraySetUp() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Twostates", "chetan", 2008);
        Book book2 = new Book("Wingoffire", "APJ", 2007);
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        library = new Library(listOfBooks);
        menuList = new ArrayList<String>();
        menuList.add("1.List of books");
        menuList.add("2.Checkout books");
    }
}
