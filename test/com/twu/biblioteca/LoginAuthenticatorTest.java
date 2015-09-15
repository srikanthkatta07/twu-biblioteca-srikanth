package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LoginAuthenticatorTest {

    @Test
    public void shouldReturnTheUserDetailsIfUserEntersValidCredentials() {
        User user1 = new User("123-7777", "abcd123", "srikanth", "9666837099", "srikant@gmail.com");
        User user2 = new User("111-8888", "1234", "kanth", "7660029499", "sri@gmail.com");
        ArrayList<User> users = new ArrayList<User>();

        users.add(user1);
        users.add(user2);
        LoginAuthenticator loginAuthenticator = new LoginAuthenticator(users);

        assertEquals(user1, loginAuthenticator.authenticate("123-7777", "abcd123"));
    }

    @Test
    public void shouldNotReturnTheUserDetailsIfUserEntersInValidCredentials() {
        User user1 = new User("123-7777", "abcd123", "srikanth", "9666837099", "srikant@gmail.com");
        User user2 = new User("111-8888", "1234", "kanth", "7660029499", "sri@gmail.com");
        ArrayList<User> users = new ArrayList<User>();

        users.add(user1);
        users.add(user2);
        LoginAuthenticator loginAuthenticator = new LoginAuthenticator(users);

        assertEquals(null, loginAuthenticator.authenticate("111-7777", "abcd123"));
    }
}
