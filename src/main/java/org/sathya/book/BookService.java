package org.sathya.book;

import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> findByAuthor(String author);
}
