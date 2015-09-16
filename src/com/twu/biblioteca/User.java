package com.twu.biblioteca;

public class User {

    private String role;
    private String email;
    private String phoneNumber;
    private String name;
    private String password;
    private String libraryNumber;

    public User(String libraryNumber, String password, String name, String phoneNumber, String email, String role) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;

    }

    @Override
    public String toString() {
        return String.format("%-20S%-20S%-20S%-20S\n", name, phoneNumber,email,role);
    }


    public boolean authenticate(String libraryNumber, String password) {
        if ((this.libraryNumber.equals(libraryNumber)) && (this.password.equals(password)))
            return true;
        return false;
    }

    @Override
    public boolean equals(Object object) {
        User that = (User) object;
        if ((that.libraryNumber).equals(this.libraryNumber))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return libraryNumber.hashCode();
    }

    public String getRole() {
        return role;
    }
}
