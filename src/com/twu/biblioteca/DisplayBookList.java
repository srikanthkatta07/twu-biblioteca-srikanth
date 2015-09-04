//To display the list of books
package com.twu.biblioteca;

import java.util.ArrayList;

public class DisplayBookList {
    private ArrayList<String> listOfBooks;

    public DisplayBookList(ArrayList<String> listOfBooks) {
        this.listOfBooks = listOfBooks;

    }

    public void displayBookList() {
        for (String book : listOfBooks)
            System.out.println(book);
    }
}
