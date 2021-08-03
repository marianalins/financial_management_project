package com.example.projeto_mariana.controller;

import com.example.projeto_mariana.model.Person;
import com.example.projeto_mariana.business.PersonBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
@Slf4j
public class PersonController {

    @Autowired
    private PersonBusiness personBusiness;

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Person> getPerson(@PathVariable int id) {
        log.info("Receiving HTTP request objmct");
        return (ResponseEntity<Person>) personBusiness.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
        //this.personBusiness.getPerson();
        //final Person person = new Person ("Paulo","Almeida");
        //return ResponseEntity.ok();

    }

    @PostMapping
    public Person addPerson(@RequestBody Person person) {
        return (Person) personBusiness.save(person);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Person>> list() {
        log.info("Receiving HTTP request ");
        this.personBusiness.findAll();
        return ResponseEntity.ok(new ArrayList<Person>());

    }
}


