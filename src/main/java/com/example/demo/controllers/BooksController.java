package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final Map<Integer, String> books = new HashMap<>();

    public BooksController() {
        books.put(1, "Noapte Buna, copii!");
        books.put(2, "Radu Pavel Gheo");
    }

    @GetMapping
    public Collection<String> getAllBooks() {
        return books.values();
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable int id) {
        return books.getOrDefault(id, "Book not found");
    }

    @PostMapping
    public String createBook(@RequestBody String title) {
        int newId = books.size() + 1;
        books.put(newId, title);
        return "Book created with ID: " + newId;
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @RequestBody String title) {
        if (books.containsKey(id)) {
            books.put(id, title);
            return "Book with ID " + id + " updated to: " + title;
        } else {
            return "Book not found";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        if (books.remove(id) != null) {
            return "Book with ID " + id + " deleted.";
        } else {
            return "Book not found";
        }
    }
}