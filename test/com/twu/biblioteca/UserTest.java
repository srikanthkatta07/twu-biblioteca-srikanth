package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void shouldReturnTheDetailsOfTheUser() {
        User user = new User("123-7777", "abcd123", "srikanth", "9666837099", "srikant@gmail.com","admin");
        String format = String.format("srikanth\t9666837099\tsrikant@gmail.com\tadmin");

        assertEquals(format, user.toString());
    }

    @Test
    public void shouldAuthenticateSuccessfulIfLibrayNumberAndPasswordAreValid() {
        User user = new User("123-7777", "abcd123", "srikanth", "9666837099", "srikant@gmail.com","user");

        assertEquals(true, user.authenticate("123-7777", "abcd123"));
    }

    @Test
    public void shouldAuthenticateUnSuccessfulIfLibrayNumberAndPasswordAreNotValid() {
        User user = new User("123-7777", "abcd123", "srikanth", "9666837099", "srikant@gmail.com","user");

        assertEquals(false, user.authenticate("123-8888", "abcd123"));
    }
}
