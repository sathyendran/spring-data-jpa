package org.sathya.book;

import java.util.List;

public interface BookRepo {
    List<Book> findByAuthor(String author);
}
