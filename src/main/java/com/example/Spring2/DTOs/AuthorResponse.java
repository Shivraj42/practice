package com.example.Spring2.DTOs;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AuthorResponse {

    String name;
    int age;

}
