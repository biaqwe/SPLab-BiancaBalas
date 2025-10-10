package com.example.demo.bookmodel;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private List<Author> authors = new ArrayList<>();
    private TableOfContents tableOfContents;
    private List<Chapter> chapters = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addChapter(Chapter chapter) {
        chapters.add(chapter);
    }

    public void setTableOfContents(TableOfContents toc) {
        this.tableOfContents = toc;
    }

    public void print() {
        System.out.println("Book: " + title);
        System.out.println();
        System.out.println("Authors:");
        for (Author a : authors) {
            a.print();
        }
        System.out.println();
        if (tableOfContents != null) {
            tableOfContents.print();
        }
        for (Chapter c : chapters) {
            c.print();
        }
    }
}
