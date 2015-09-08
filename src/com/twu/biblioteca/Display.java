//To display all the messages to the user
package com.twu.biblioteca;

import java.util.ArrayList;

public class Display {

    private Library library;

    public Display(Library library) {
        this.library = library;

    }

    public void displayBookList() {
        for (Book book : library.getListOfBooks())
            System.out.println(book.getDetails());
    }

    public void displayInvalidCommand() {
        System.out.println("Select an valid option!");


    }

    public void displayMessage(String welcomeMessage) {
        System.out.println(welcomeMessage);
    }

    public void exitMenu() {
        System.exit(0);
    }

    public void displaySuccessfulCheckOut() {
        System.out.println("Thank you! Enjoy the book");
    }
}
