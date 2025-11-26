package com.example.demo;

import com.example.demo.bookmodel.*;
import com.example.demo.difexamples.ClientComponent;
import com.example.demo.difexamples.SingletonComponent;
import com.example.demo.difexamples.TransientComponent;
import com.example.demo.persistence.BooksRepository; // Import necesar
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Demo2Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Demo2Application.class, args);

        TransientComponent transientBean = context.getBean(TransientComponent.class);
        transientBean.operation();

        SingletonComponent singletonBean = context.getBean(SingletonComponent.class);
        singletonBean.operation();

        singletonBean = context.getBean(SingletonComponent.class);
        singletonBean.operation();

        ClientComponent c = context.getBean(ClientComponent.class);
        c.operation();

        c = (ClientComponent) context.getBean("clientComponent");
        c.operation();

        Book noapteBuna = new Book("Noapte Buna, copii!");
        Author rpGheo = new Author("Radu Pavel", "Gheo");
        noapteBuna.addAuthor(rpGheo);

        Section cap1 = new Section("Cap1");
        Section cap11 = new Section("Cap1.1");
        Section cap111 = new Section("Cap1.1.1");
        Section cap1111 = new Section("Subchapter 1.1.1.1");

        noapteBuna.add(new Paragraph("Multumesc celor care..."));
        noapteBuna.add(cap1);
        cap1.add(new Paragraph("Moto capitol"));
        cap1.add(cap11);
        cap11.add(new Paragraph("Text from subchapter 1.1"));
        cap11.add(cap111);
        cap111.add(new Paragraph("Text from subchapter 1.1.1"));
        cap111.add(cap1111);
        cap1111.add(new Image("Image subchapter 1.1.1.1"));

        BooksRepository booksRepository = context.getBean(BooksRepository.class);

        booksRepository.save(noapteBuna);

        System.out.println("Cartea a fost salvată în baza de date cu succes!");

    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }
}