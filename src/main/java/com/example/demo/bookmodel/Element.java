package com.example.demo.bookmodel;

public interface Element {
    void print();

    default void add(Element e) {
        throw new UnsupportedOperationException("Operation not supported for leaf elements.");
    }

    default void remove(Element e) {
        throw new UnsupportedOperationException("Operation not supported for leaf elements.");
    }

    default Element get(int index) {
        throw new UnsupportedOperationException("Operation not supported for leaf elements.");
    }
}
