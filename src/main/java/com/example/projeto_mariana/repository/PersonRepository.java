package com.example.projeto_mariana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projeto_mariana.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {  }
