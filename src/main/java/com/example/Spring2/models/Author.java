package com.example.Spring2.models;

import com.example.Spring2.Enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "author")
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int authorId;

    String name;

    int age;

    Gender gender;

    int rating;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    List<Book> books= new ArrayList<>();

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    List<Publish> publishes= new ArrayList<>();


}
