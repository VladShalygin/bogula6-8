package ru.laba.crudlaba.repository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import ru.laba.crudlaba.model.Person;

@Repository
public class PersonRepository extends BaseRepository<Person> {
    public PersonRepository(MongoTemplate mongoTemplate) {
        super(mongoTemplate, Person.class);
    }
}