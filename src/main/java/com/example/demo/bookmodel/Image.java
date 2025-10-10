package com.example.demo.bookmodel;

public class Image implements Element {
    private final String url;

    public Image(String url) {
        this.url = url;
    }

    @Override
    public void print() {
        System.out.println("Image with name: " + url);
    }

}
