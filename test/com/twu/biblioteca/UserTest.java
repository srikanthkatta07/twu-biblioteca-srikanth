package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void shouldReturnTheDetailsOfTheUser() {
        User user = new User("123-7777", "abcd123", "srikanth", "9666837099", "srikant@gmail.com", "admin");
        String format = String.format("%-20S%-20S%-20S%-20S", "srikanth", "9666837099", "srikant@gmail.com", "admin");

        assertEquals(format, user.toString());
    }

    @Test
    public void shouldAuthenticateSuccessfulIfLibrayNumberAndPasswordAreValid() {
        User user = new User("123-7777", "abcd123", "srikanth", "9666837099", "srikant@gmail.com", "user");

        assertEquals(true, user.authenticate("123-7777", "abcd123"));
    }

    @Test
    public void shouldAuthenticateUnSuccessfulIfLibrayNumberAndPasswordAreNotValid() {
        User user = new User("123-7777", "abcd123", "srikanth", "9666837099", "srikant@gmail.com", "user");

        assertEquals(false, user.authenticate("123-8888", "abcd123"));
    }

    @Test
    public void shouldEqualsToOtherUserIfBothHaveSameLibraryNumber() {
        User user1 = new User("123-7777", "abcd123", "srikanth", "9666837099", "srikant@gmail.com", "user");
        User user2 = new User("123-7777", "abcd123", "srika", "9666837099", "srikant@gmail.com", "user");

        assertEquals(user1, user2);
    }


    @Test
    public void shouldNotEqualsToOtherUserIfBothHaveDifferentLibraryNumber() {
        User user1 = new User("123-7777", "abcd123", "srikanth", "9666837099", "srikant@gmail.com", "user");
        User user2 = new User("123-7787", "abcd123", "srika", "9666837099", "srikant@gmail.com", "user");

        assertNotEquals(user1, user2);
    }

    @Test
    public void shouldGiveTheRoleOfTheUser() {
        User user1 = new User("123-7777", "abcd123", "srikanth", "9666837099", "srikant@gmail.com", "user");

        assertEquals("user", user1.getRole());
    }
}
