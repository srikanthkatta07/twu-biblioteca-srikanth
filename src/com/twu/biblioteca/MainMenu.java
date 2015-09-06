package com.twu.biblioteca;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;

public class MainMenu {
    private DisplayBookList bookList;
    ArrayList<String> menuList;

    public MainMenu(ArrayList<String> menuList, DisplayBookList bookList) {
        this.menuList = menuList;
        this.bookList = bookList;
    }

    public void showMenuList() {
        for (String options : menuList)
            System.out.println(options);
    }

    public void selectOption(String option) {
        if (option.equals("1"))
            bookList.displayBookList();
        else
            bookList.displayInvalidCommand();
    }
}
