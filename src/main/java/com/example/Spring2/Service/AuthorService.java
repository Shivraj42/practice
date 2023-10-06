package com.example.Spring2.Service;

import com.example.Spring2.DTOs.AuthorResponse;
import com.example.Spring2.Enums.Gender;
import com.example.Spring2.Repository.AuthorRepo;
import com.example.Spring2.models.Author;
import com.example.Spring2.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepo authorRepo;


    public int addAuthor(String name, int age, Gender gender, int rating) {

        Author author = Author.builder()
                .age(age)
                .name(name)
                .gender(gender)
                .rating(rating)
                .build();

        Author savedAuthor = authorRepo.save(author);

        return savedAuthor.getAuthorId();
    }

    public AuthorResponse getAuthorWithMaxPages() {

        List<Author> authors= authorRepo.findAll();
        int maxPages=0;
        Author maxAuthor=null;

        for(Author author:authors){
            int pages=0;
            for(Book book:author.getBooks()){
                pages+= book.getPages();
            }
            if(maxPages<pages){
                maxPages=pages;
                maxAuthor=author;
            }
        }

        AuthorResponse authorResponse= AuthorResponse.builder()
                .name(maxAuthor.getName())
                .age(maxAuthor.getAge())
                .build();

        return authorResponse;
    }
}
