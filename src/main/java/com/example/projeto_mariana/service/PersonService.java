package com.example.projeto_mariana.service;

import com.example.projeto_mariana.model.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonService {

    Person getPerson(Long id);
    Optional<Person> getPersonByFullName(Person person);
    void addPerson(Person person);
    void delete(Long id);
    ResponseEntity<Person> update(Long id, Person personInfo);
    List<Person> list();

}
