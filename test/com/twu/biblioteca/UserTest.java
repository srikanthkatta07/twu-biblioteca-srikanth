package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void shouldReturnTheDetailsOfTheUser() {
        User user=new User("123-7777","abcd123","srikanth","9666837099","srikant@gmail.com");
        String format = String.format("srikanth\t9666837099\tsrikant@gmail.com");

        assertEquals(format,user.toString());
    }
}
