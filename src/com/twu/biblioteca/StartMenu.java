package com.twu.biblioteca;

import java.util.ArrayList;

public class StartMenu {

    private ArrayList<String> startMenuList = new ArrayList<String>();

    public StartMenu() {
        startMenuList.add("1.LogIn");
        startMenuList.add("2.As Guest");

    }

    public void showStartMenuList() {
        for (String starMenuOption : startMenuList)
            System.out.println(starMenuOption);
    }
}
