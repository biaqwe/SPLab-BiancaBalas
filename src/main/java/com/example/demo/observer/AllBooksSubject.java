package com.example.demo.observer;

import com.example.demo.bookmodel.Book;
import org.springframework.stereotype.Component;

@Component
public class AllBooksSubject extends Subject {

    public void add(Book book) {
        notifyObservers(book);
    }

    @Override
    public void notifyObservers(Book book) {
        for (Observer observer : observerCollection) {
            observer.update(book);
        }
    }
}