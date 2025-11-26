package com.example.demo.bookmodel;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(force = true)
public class Book extends BaseElement {
    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Author> authors = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<BaseElement> children = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    @Override
    public void add(Element e) {
        if (e instanceof BaseElement) {
            children.add((BaseElement) e);
        }
    }

    @Override
    public void remove(Element e) {
        children.remove(e);
    }

    @Override
    public Element get(int index) {
        return children.get(index);
    }

    @Override
    public void print() {
        System.out.println("Book: " + title);
        System.out.println("Authors:");
        for (Author a : authors) {
            a.print();
        }
        for (BaseElement e : children) {
            e.print();
        }
    }
}