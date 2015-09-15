package com.twu.biblioteca;

public class User {

    private String email;
    private String phoneNumber;
    private String name;
    private String password;
    private String libraryNumber;

    public User(String libraryNumber, String password, String name, String phoneNumber, String email) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;

    }

    @Override
    public String toString() {
        return String.format(name + "\t" + phoneNumber + "\t" + email);
    }


    public boolean authenticate(String libraryNumber, String password) {
        if ((this.libraryNumber.equals(libraryNumber)) && (this.password.equals(password)))
            return true;
        return false;
    }
}
