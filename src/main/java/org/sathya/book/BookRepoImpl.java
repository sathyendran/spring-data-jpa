package org.sathya.book;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class BookRepoImpl implements BookRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> findByAuthor(String author) {
        Query query = entityManager.createQuery("select b from Book b where b.author = :author", Book.class);
        query.setParameter("author", author);
        return query.getResultList();
    }
}
