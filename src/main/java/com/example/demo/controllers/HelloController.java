package com.example.demo.controllers;

import com.example.demo.difexamples.ClientComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final ClientComponent clientComponent;
    private final ObjectProvider<ClientComponent> clientProvider;

    @GetMapping("/")
    public String helloRoot() {
        return "Hello from Spring Boot";
    }

    @GetMapping("/client")
    public String helloFromClient() {
        return "Hello from ClientComponent = " + clientComponent;
    }

    @GetMapping("/client-multiple")
    public String multipleClients() {
        ClientComponent c1 = clientProvider.getObject();
        ClientComponent c2 = clientProvider.getObject();
        return "c1 = " + c1 + ", c2 = " + c2;
    }
}