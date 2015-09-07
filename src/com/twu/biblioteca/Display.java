//To display all the messages to the user
package com.twu.biblioteca;

import java.util.ArrayList;

public class Display {

    private ArrayList<Book> listOfBooks;

    public Display(ArrayList<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;

    }

    public void displayBookList() {
        for (Book book : listOfBooks)
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

}
