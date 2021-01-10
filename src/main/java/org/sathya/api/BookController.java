package org.sathya.api;

import lombok.extern.slf4j.Slf4j;
import org.sathya.book.Book;
import org.sathya.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@Slf4j
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book save(@RequestBody Book book) {
        log.info("Saving the book {}",book);
        return bookService.save(book);
    }
    @GetMapping("/custom-repo")
    public List<Book> findByAuthor(@RequestParam String author) {
        log.info("Fetching the book by author: {}",author);
        return bookService.findByAuthor(author);
    }
 }
