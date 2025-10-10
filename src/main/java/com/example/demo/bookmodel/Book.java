package com.example.demo.bookmodel;

import java.util.ArrayList;
import java.util.List;

public class Book extends Section {
    private final List<Author> authors = new ArrayList<>();

    public Book(String title) {
        super(title);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    @Override
    public void print() {
        System.out.println("Book: " + title);
        System.out.println();

        System.out.println("Authors:");
        for (Author a : authors) {
            a.print();
        }
        System.out.println();

        for (Element e : children) {
            e.print();
        }
    }

}
