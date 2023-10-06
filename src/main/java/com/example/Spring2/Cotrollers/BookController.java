package com.example.Spring2.Cotrollers;

import com.example.Spring2.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add-book")
    public ResponseEntity addBook(@RequestParam String name,
                                  @RequestParam String authorName,
                                  @RequestParam int pages){
        int response= bookService.addBook(name, authorName, pages);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

//    @GetMapping("/total-books-published-by-author/{author}/in-year/{year}")
//    public  ResponseEntity findBooksByAuthorInYear(@PathVariable ("author")String author,
//                                                   @PathVariable("year") int year){
//
//    }
    // YE BANAYA NAHI THA apI QUESTION WRONG THA BUT  PUCH SAKTA HAI

}
