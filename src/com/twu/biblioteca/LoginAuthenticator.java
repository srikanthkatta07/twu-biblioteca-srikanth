package com.twu.biblioteca;

import java.util.ArrayList;

public class LoginAuthenticator {

    private ArrayList<User> users;

    public LoginAuthenticator(ArrayList<User> users) {
        this.users = users;
    }

    public User authenticate(String libraryNumber, String password) {
        return users.get(0);
    }
}
