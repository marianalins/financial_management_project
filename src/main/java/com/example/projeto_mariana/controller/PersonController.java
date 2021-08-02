package com.example.projeto_mariana.controller;

import com.example.projeto_mariana.Person;
import com.example.projeto_mariana.business.PersonBusiness;
import com.example.projeto_mariana.business.PersonBusinessImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
@Slf4j
public class PersonController {

    @Autowired
    private PersonBusiness personBusiness;

    @GetMapping
    public ResponseEntity<Person> getPerson() {
        log.info("Receiving HTTP request objmct");
        //this.personBusiness.getPerson();
        //final Person person = new Person ("Paulo","Almeida");
        //return ResponseEntity.ok();

    }

    @GetMapping("/list")
    public ResponseEntity<List<Person>> list() {
        log.info("Receiving HTTP request ");
        //final Person person = new Person ("Paulo","Almeida");
        return ResponseEntity.ok(new ArrayList<Person>());

    }
