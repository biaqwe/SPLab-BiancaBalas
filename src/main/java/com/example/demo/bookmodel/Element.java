package com.example.demo.bookmodel;

public interface Element {
    void print();
    default void add(Element e) {
        throw new UnsupportedOperationException(getClass().getSimpleName() + " is a leaf.");
    }

    default void remove(Element e) {
        throw new UnsupportedOperationException(getClass().getSimpleName() + " is a leaf.");
    }

    default Element get(int index) {
        throw new UnsupportedOperationException(getClass().getSimpleName() + " is a leaf.");
    }
}
