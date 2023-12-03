package ru.laba.crudlaba.Configuration;

import com.mongodb.client.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "crud_laba";
    }

    @Override
    @Bean
    public MongoClient mongoClient() {
        return super.mongoClient();
    }
}