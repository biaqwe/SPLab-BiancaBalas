package com.example.demo.bookmodel;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@jakarta.persistence.Table(name = "print_table")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(force = true)
public class Table extends BaseElement {
    private String title;

    public Table(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println("Table: " + title);
    }
}