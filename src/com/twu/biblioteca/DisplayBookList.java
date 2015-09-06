//To display the list of books
package com.twu.biblioteca;

import java.util.ArrayList;

public class DisplayBookList {
    private ArrayList<Book> listOfBooks;

    public DisplayBookList(ArrayList<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;

    }

    public void displayBookList() {
        for (Book book : listOfBooks)
            System.out.println(book.getDetails());
    }

    public void displayInvalidCommand() {
        System.out.println("Select a valid option!");
    }
}
