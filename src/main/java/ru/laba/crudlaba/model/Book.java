package ru.laba.crudlaba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@Document
public class Book {

    @Id
    String id;
    String name;
    String author;
    int pages;

}
