package com.example.demo.bookmodel;

public class Table implements Element {
    private final String caption;

    public Table(String caption) {
        this.caption = caption;
    }

    @Override
    public void print() {
        System.out.println(": " + caption);
    }
}
