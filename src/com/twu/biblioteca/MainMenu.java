package com.twu.biblioteca;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;

public class MainMenu {
    ArrayList<String> menuList;

    public MainMenu(ArrayList<String> menuList) {
        this.menuList=menuList;
    }

    public void showMenuList() {
       for(String options:menuList)
           System.out.println(options);
    }
}
