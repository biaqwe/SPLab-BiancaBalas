package com.example.demo.bookmodel;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(force = true)
public class Section extends BaseElement {
    private String title;

    @OneToMany(cascade = CascadeType.ALL)
    private List<BaseElement> children = new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

    @Override
    public void add(Element e) {
        if (e instanceof BaseElement) {
            children.add((BaseElement) e);
        }
    }

    @Override
    public void remove(Element e) {
        children.remove(e);
    }

    @Override
    public Element get(int index) {
        return children.get(index);
    }

    @Override
    public void print() {
        System.out.println("Section: " + title);
        for (BaseElement e : children) {
            e.print();
        }
    }
}