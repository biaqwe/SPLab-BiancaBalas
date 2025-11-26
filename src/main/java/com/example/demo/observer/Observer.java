package com.example.demo.observer;

import com.example.demo.bookmodel.Book;

public interface Observer {
    void update(Book book);
}