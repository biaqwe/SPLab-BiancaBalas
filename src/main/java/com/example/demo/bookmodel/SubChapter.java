package com.example.demo.bookmodel;

import java.util.ArrayList;
import java.util.List;

public class SubChapter {
    private String name;
    private List<Element> elements = new ArrayList<>();

    public SubChapter(String name) {
        this.name = name;
    }

    public void addElement(Element e) {
        elements.add(e);
    }

    public void print() {
        System.out.println(name);
        for (Element e : elements) {
            e.print();
        }
    }
}
