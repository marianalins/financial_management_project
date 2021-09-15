package com.example.projeto_mariana.controller;

import com.example.projeto_mariana.model.Person;
import com.example.projeto_mariana.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personBusiness;

    @GetMapping("/getsemparam")
    public ResponseEntity<Person> getPersonsem() {
        log.info("get sem parametro amorr ");
        //Optional<Person> person = Optional.of(personBusiness.getPerson(null));

        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getPerson(@PathVariable Long id) {
        log.info("Receiving HTTP request ");
        Optional<Person> person = Optional.ofNullable(personBusiness.getPerson(id));
        if(person.isPresent()) {
            return new ResponseEntity<Person>(person.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Person does not exist in the system", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addPerson(@RequestBody Person person) {
        log.info("Receiving HTTP request ");
        Optional<Person> optional = Optional.ofNullable(personBusiness.findPerson(person));

       if(!optional.isPresent()) {
            personBusiness.addPerson(person);
            return new ResponseEntity<>("Person added successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Person already exist in the system", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = {"/delete/{id}"})
    public ResponseEntity<String> delete(@PathVariable Long id) {
        log.info("Receiving HTTP request ");
        Optional<Person> person = Optional.ofNullable(personBusiness.getPerson(id));
        if(person.isPresent()) {
            personBusiness.delete(id);
            return new ResponseEntity<>("Person deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Person does not exist in the system", HttpStatus.NOT_FOUND);
        }


    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable(value="id") Long id, Person personInfo) {
        log.info("Receiving HTTP request ");
        return new ResponseEntity<>("Updated successfully "+ personBusiness.update(id,personInfo),HttpStatus.OK);

    }

    @GetMapping("/list")
    public ResponseEntity<List<Person>> list() {
        log.info("Receiving HTTP request ");

        return ResponseEntity.ok(personBusiness.list());

    }


}


