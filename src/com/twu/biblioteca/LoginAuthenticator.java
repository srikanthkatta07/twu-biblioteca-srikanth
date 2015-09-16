//Authenticate the user based on library number and password
package com.twu.biblioteca;

import java.util.ArrayList;

public class LoginAuthenticator {

    private ArrayList<User> users;

    public LoginAuthenticator(ArrayList<User> users) {
        this.users = users;
    }

    public User authenticate(String libraryNumber, String password) {
        for (User user : users) {
            if (user.authenticate(libraryNumber, password)) {
                return user;
            }
        }
        return null;
    }
}
