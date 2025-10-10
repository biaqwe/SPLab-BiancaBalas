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

        int indexChapter1 = noapteBuna.createChapter("Capitolul 1");
        Chapter ch1 = noapteBuna.getChapter(indexChapter1);

        SubChapter sch1 = ch1.createSubChapter("Subcapitolul 1.1");
        sch1.addElement(new Paragraph("Multumesc celor care ..."));
        sch1.addElement(new Image("Coperta"));
        sch1.addElement(new Table("Tabelul 1"));

        noapteBuna.setTableOfContents(new TableOfContents());

        noapteBuna.print();
    }
}
