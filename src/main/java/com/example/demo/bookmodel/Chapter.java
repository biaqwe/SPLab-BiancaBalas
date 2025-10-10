package com.example.demo.bookmodel;

import java.util.ArrayList;
import java.util.List;

public class Chapter {
    private String name;
    private List<SubChapter> subChapters = new ArrayList<>();

    public Chapter(String name) {
        this.name = name;
    }

    public SubChapter createSubChapter(String name) {
        SubChapter sub = new SubChapter(name);
        subChapters.add(sub);
        return sub;
    }

    public void print() {
        System.out.println(name);
        for (SubChapter s : subChapters) {
            s.print();
        }
    }
}
