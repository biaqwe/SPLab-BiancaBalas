package com.example.demo.bookmodel;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class BaseElement implements Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}