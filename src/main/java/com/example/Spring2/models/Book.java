package com.example.Spring2.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "book")
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int bookId;

    String name;

    String author_name;

    int pages;

    @ManyToOne
    @JoinColumn
    Author author;

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    Publish publish;
}