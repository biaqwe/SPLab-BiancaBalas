package com.example.demo.observer;

import com.example.demo.bookmodel.Book;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Subject {

    protected final List<Observer> observerCollection = new CopyOnWriteArrayList<>();

    public void registerObserver(Observer observer) {
        observerCollection.add(observer);
    }

    public void unregisterObserver(Observer observer) {
        observerCollection.remove(observer);
    }

    public abstract void notifyObservers(Book book);
}