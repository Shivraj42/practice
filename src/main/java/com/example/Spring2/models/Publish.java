package com.example.Spring2.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "publish")
@Builder
public class Publish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int publishId;
    @OneToOne
    @JoinColumn
    Book book;

    @ManyToOne
    @JoinColumn
    Author author;

    int year;

}
