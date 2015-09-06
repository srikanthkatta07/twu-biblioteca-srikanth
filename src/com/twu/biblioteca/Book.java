package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private int yearOfPublish;

    public Book(String name, String author, int yearOfPublish) {
        this.name = name;
        this.author = author;
        this.yearOfPublish = yearOfPublish;

    }

    public String getDetails() {
        return name + " " + author + " " + yearOfPublish;
    }
}