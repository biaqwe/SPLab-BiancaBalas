package com.example.demo.bookmodel;

import java.util.ArrayList;
import java.util.List;

public class Chapter {
    private String name;
    private List<SubChapter> subChapters = new ArrayList<>();

    public Chapter(String name) {
        this.name = name;
    }

    public void addSubChapter(SubChapter sub) {
        subChapters.add(sub);
    }

    public void print() {
        System.out.println(name);
        for (SubChapter sub : subChapters) {
            sub.print();
        }
    }
}
