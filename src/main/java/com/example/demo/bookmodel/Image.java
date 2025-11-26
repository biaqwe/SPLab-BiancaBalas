package com.example.demo.bookmodel;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(force = true)
public class Image extends BaseElement {
    private String url;

    public Image(String url) {
        this.url = url;
    }

    @Override
    public void print() {
        System.out.println("Image with name: " + url);
    }
}