//returning details of the book
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
        String format = String.format("%-20S%-20S%-20S", name, author, yearOfPublish);
        return format;
    }

    public boolean findByBookName(String bookName) {
        if (this.name.equals(bookName))
            return true;
        return false;
    }

    @Override
    public boolean equals(Object object) {
        Book that = (Book) object;
        if (that.hashCode() == this.hashCode())
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 7 + name.hashCode();
        return hash;
    }
}
