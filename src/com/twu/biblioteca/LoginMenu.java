//Displaying login menu options to the user
package com.twu.biblioteca;

import java.util.ArrayList;

public class LoginMenu {

    private ArrayList<String> loginMenuList = new ArrayList<String>();

    public LoginMenu() {
        loginMenuList.add("1.LogIn");
        loginMenuList.add("2.As Guest");
        loginMenuList.add("3.Quit");

    }

    public void showLoginMenuList() {
        for (String starMenuOption : loginMenuList)
            System.out.println(starMenuOption);
    }
}
