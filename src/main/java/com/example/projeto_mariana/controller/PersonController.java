package com.example.projeto_mariana.controller;

import com.example.projeto_mariana.model.Person;
import com.example.projeto_mariana.business.PersonBusiness;
import com.example.projeto_mariana.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@Slf4j
public class PersonController {

    @Autowired
    private PersonBusiness personBusiness;

    @GetMapping("/get/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        log.info("Receiving HTTP request ");
        Optional<Person> person = Optional.of(personBusiness.getPerson(id));

        return ResponseEntity.ok(person.orElse(null));
    }

    @PostMapping("/add")
    public void addPerson(Person person) {
        personBusiness.addPerson(person);
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<Person> delete(Long id) {
        log.info("Receiving HTTP request ");
        personBusiness.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<Person>> list() {
        log.info("Receiving HTTP request ");

        return ResponseEntity.ok(personBusiness.list());

    }


}


