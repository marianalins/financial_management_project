package com.example.projeto_mariana.business;

import com.example.projeto_mariana.model.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonBusiness {

    public Person getPerson(Long id);
    public Person findPerson(Person person);
    public void addPerson(Person person);
    public void delete(Long id);
    public ResponseEntity<Person> update(Long id, Person personInfo);
    public List<Person> list();

}
