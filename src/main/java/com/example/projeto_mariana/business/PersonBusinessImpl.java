package com.example.projeto_mariana.business;

import com.example.projeto_mariana.model.Person;

import com.example.projeto_mariana.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonBusinessImpl implements PersonBusiness{

    @Autowired
    private PersonRepository personRepository;

    public Person getPerson(Long id){
        return personRepository.findById(id).orElse(null);
    }

    public Person findPerson(Person person){
        List<Person> listPerson = list();
        for(int i = 0; i <= listPerson.size() - 1 ;i++) {
            if(listPerson.get(i).getFirstName().equals(person.getFirstName()) &&
                    listPerson.get(i).getLastName().equals(person.getLastName())) {
                return person;
            }
        }
        return null;
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    public ResponseEntity<Person> update(Long id, Person personInfo) {
        Person person =  personRepository.findById(id).orElse(null);
        person.setFirstName(personInfo.getFirstName());
        person.setLastName(personInfo.getLastName());
        final Person updatedPerson = personRepository.save(person);
        return ResponseEntity.ok(updatedPerson);
    }

    public List<Person> list() {
        return personRepository.findAll();
    }


}
