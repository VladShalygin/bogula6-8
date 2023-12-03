package ru.laba.crudlaba.repository;
import com.mongodb.client.result.DeleteResult;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;
import java.util.Optional;


public abstract class BaseRepository<T> {

    private final MongoTemplate mongoTemplate;
    private final Class<T> entityType;

    public BaseRepository(MongoTemplate mongoTemplate, Class<T> entityType) {
        this.mongoTemplate = mongoTemplate;
        this.entityType = entityType;
    }
    public T save(T entity) {
        return mongoTemplate.save(entity);
    }

    public T findById(String id) {
        return mongoTemplate.findById(id, entityType);
    }

    public List<T> findAll() { return mongoTemplate.findAll(entityType);}
    public void deleteById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, entityType);
    }

    public boolean exists(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.exists(query, entityType);
    }
    public long delete(T entity) {
        DeleteResult result = mongoTemplate.remove(entity);
        return result.getDeletedCount();
    }
}

