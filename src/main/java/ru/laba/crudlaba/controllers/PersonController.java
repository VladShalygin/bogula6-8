package ru.laba.crudlaba.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.laba.crudlaba.model.Person;
import ru.laba.crudlaba.repository.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("/persons")
@AllArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personRepository.findAll();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    // Получение информации о конкретном человеке по ID
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable String id) {
        return ResponseEntity.ok(personRepository.findById(id));
    }

    // Создание нового человека
    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person savedPerson = personRepository.save(person);
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }

    // Обновление информации о человеке по ID
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable String id, @RequestBody Person updatedPerson) {
        Person existingPerson = personRepository.findById(id);
        if (existingPerson != null) {
            if (updatedPerson.getFirstName() != null) {
                existingPerson.setFirstName(updatedPerson.getFirstName());
            }
            if (updatedPerson.getLastName() != null) {
                existingPerson.setLastName(updatedPerson.getLastName());
            }
            if (updatedPerson.getAge() != 0) {
                existingPerson.setAge(updatedPerson.getAge());

            }
            Person savedPerson = personRepository.save(existingPerson);
            return new ResponseEntity<>(savedPerson, HttpStatus.OK);
        } else {
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable String id) {
        if (personRepository.exists(id)) {
            personRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
