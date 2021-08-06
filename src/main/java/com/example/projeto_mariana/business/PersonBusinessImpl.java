package com.example.projeto_mariana.business;

import com.example.projeto_mariana.model.Person;

import com.example.projeto_mariana.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonBusinessImpl implements PersonBusiness{

    @Autowired
    private PersonRepository personRepository;

    public Person getPerson(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    public List<Person> list() {
        return personRepository.findAll();
    }


}
