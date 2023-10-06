package com.example.Spring2.Cotrollers;

import com.example.Spring2.DTOs.AuthorResponse;
import com.example.Spring2.Enums.Gender;
import com.example.Spring2.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/add-author")
    public ResponseEntity addAuthor(@RequestParam String name,
                                    @RequestParam int age,
                                    @RequestParam Gender gender,
                                    @RequestParam int rating){
        int response= authorService.addAuthor(name, age, gender, rating);
        return  new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/find-author-with-max-pages-written-in-lifetime")
    public ResponseEntity getAuthorWithMaxPages(){
        AuthorResponse respose= authorService.getAuthorWithMaxPages();
        return  new ResponseEntity(respose, HttpStatus.FOUND);
    }
}
