package com.example.projeto_mariana.service;

import com.example.projeto_mariana.model.Person;

import com.example.projeto_mariana.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;


    public Person getPerson(Long id){
        return personRepository.findById(id).orElse(null);
    }


    public Optional<Person> getPersonByFullName(Person person) {
        return personRepository.findByFullName(person.getFirstName(),person.getLastName());
    }

    public void addPerson(Person person){
        personRepository.save(person);
    }

    public void delete(Long id){
        personRepository.deleteById(id);
    }

    public ResponseEntity<Person> update(Long id, Person personInfo) {
        Person person =  personRepository.findById(id).orElse(null);
        person.setFirstName(personInfo.getFirstName());
        person.setLastName(personInfo.getLastName());
        return ResponseEntity.ok(personRepository.save(person));
    }

    public List<Person> list(){
        return personRepository.findAll();
    }


}
