package com.twu.biblioteca;

import java.util.ArrayList;

public class UserFactory {

    private ArrayList<User> users;

    public ArrayList<User> setUp() {
        users = new ArrayList<User>();
        User user1 = new User("123-7777", "abcd123", "srikanth", "9666837099", "srikanthk@gmail.com", "librarian");
        User user2 = new User("111-8888", "abcd", "kanth", "7660029499", "kanth@gmail.com", "user");
        users.add(user1);
        users.add(user2);
        return users;
    }
}
