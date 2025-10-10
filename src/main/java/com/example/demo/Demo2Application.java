package com.example.demo;

import com.example.demo.bookmodel.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class Demo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);

        Book noapteBuna = new Book("Noapte buna, copii!");
        Author rpGheo = new Author("Radu Pavel Gheo");
        noapteBuna.addAuthor(rpGheo);

        Chapter cap1 = new Chapter("Capitolul 1");
        noapteBuna.addChapter(cap1);

        SubChapter sub1 = new SubChapter("Subcapitol 1.1");
        cap1.addSubChapter(sub1);

        sub1.addParagraph(new Paragraph("Multumesc celor care ..."));
        sub1.addImage(new Image("Imagine 1"));
        sub1.addTable(new Table("Tabel 1"));

        noapteBuna.setTableOfContents(new TableOfContents());

        noapteBuna.print();
    }
}
