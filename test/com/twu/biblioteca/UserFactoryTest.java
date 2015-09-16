package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class UserFactoryTest {
    @Test
    public void shouldInitializeTheListOfUsers() {
        UserFactory userFactory = new UserFactory();
        ArrayList<User> users = new ArrayList<User>();
        User user1 = new User("123-7777", "abcd123", "srikanth", "9666837099", "srikanthk@gmail.com", "librarian");
        User user2 = new User("111-8888", "abcd", "kanth", "7660029499", "kanth@gmail.com", "user");

        users.add(user1);
        users.add(user2);

        assertEquals(users, userFactory.setUp());
    }
}
