package ru.laba.crudlaba.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import ru.laba.crudlaba.model.Book;

@Repository
public class BookRepository extends BaseRepository<Book> {

    @Autowired
    public BookRepository(MongoTemplate mongoTemplate) {
        super(mongoTemplate, Book.class);
    }
}