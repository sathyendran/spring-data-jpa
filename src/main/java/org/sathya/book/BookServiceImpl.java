package org.sathya.book;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        log.info("Saving the book details : {}",book);
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        log.info("Finding book by authors: {} ",author);
        return bookRepository.findByAuthor(author);
    }
}
