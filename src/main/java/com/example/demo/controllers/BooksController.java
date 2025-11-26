package com.example.demo.controllers;

import com.example.demo.bookmodel.Book;
import com.example.demo.persistence.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

    private final BooksRepository booksRepository;

    @GetMapping
    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return booksRepository.findById(id)
                .map(book -> ResponseEntity.ok(book))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        // [cite: 75] Save the book to the database
        return booksRepository.save(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBookDetails) {
        return booksRepository.findById(id)
                .map(book -> {
                    book.setTitle(updatedBookDetails.getTitle());
                    return ResponseEntity.ok(booksRepository.save(book));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        if (booksRepository.existsById(id)) {
            booksRepository.deleteById(id);
            return ResponseEntity.ok("Book with ID " + id + " deleted.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}