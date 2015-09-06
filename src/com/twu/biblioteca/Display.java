//To display the list of books
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
        System.out.println("Select a valid option!");
    }

    public void displayMessage(String welcomeMessage) {
        System.out.println(welcomeMessage);
    }
}
