package com.example.Spring2.Service;

import com.example.Spring2.Repository.AuthorRepo;
import com.example.Spring2.Repository.BookRepo;
import com.example.Spring2.models.Author;
import com.example.Spring2.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepo bookRepo;

    @Autowired
    AuthorRepo authorRepo;


    public int addBook(String name, String authorName, int pages) {
        Author author= authorRepo.findByName(authorName);
        Book book= Book.builder()
                .author_name(authorName)
                .pages(pages)
                .name(name)
                .author(author)
                .build();
        author.getBooks().add(book);

        Book savedBook= bookRepo.save(book);

        return  savedBook.getBookId();
    }
}
