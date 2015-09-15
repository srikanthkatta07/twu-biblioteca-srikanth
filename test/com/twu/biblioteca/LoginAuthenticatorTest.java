package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

public class LoginAuthenticatorTest {

    @Test
    public void shouldReturnTheUserDetailsIfUserEntersValidCredentials() {
        ArrayList<User> users = new ArrayList<User>();
        LoginAuthenticator loginAuthenticator = new LoginAuthenticator(users);
    }
}
