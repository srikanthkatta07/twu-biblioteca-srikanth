//Initializing the list of books in the library
package com.twu.biblioteca;

import java.util.ArrayList;

public class LibraryFactory {

    public Library setUp() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();

        Book book1 = new Book("TWOSTATES", "CHETAN", 2008);
        Book book2 = new Book("WINGSOFFIRE", "APJ", 2007);
        Book book3 = new Book("HARRY POTTER", "JK", 2006);
        Book book4 = new Book("FIVEPOINT SOMEONE", "CHETAN", 2004);
        Book book5 = new Book("REVOLUTION 2020", "CHETAN", 2006);
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        listOfBooks.add(book3);
        listOfBooks.add(book4);
        listOfBooks.add(book5);

        return new Library(listOfBooks);
    }
}
