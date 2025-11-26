package com.example.demo.controllers;

import com.example.demo.observer.AllBooksSubject;
import com.example.demo.observer.SseObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/books-sse")
@RequiredArgsConstructor
public class BooksSseController {

    private final AllBooksSubject allBooksSubject;

    @GetMapping
    public SseEmitter getBooksSse() {
        final SseEmitter emitter = new SseEmitter(0L);

        final SseObserver observer = new SseObserver(emitter);

        allBooksSubject.registerObserver(observer);

        emitter.onCompletion(() -> allBooksSubject.unregisterObserver(observer));
        emitter.onTimeout(() -> allBooksSubject.unregisterObserver(observer));
        emitter.onError((e) -> allBooksSubject.unregisterObserver(observer));

        return emitter;
    }
}