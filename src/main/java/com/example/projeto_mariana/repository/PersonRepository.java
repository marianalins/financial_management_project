package com.example.projeto_mariana.repository;

import com.example.projeto_mariana.model.Nf;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projeto_mariana.model.Person;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("select p from Person p where p.firstName = ?1 and p.lastName = ?2")
    Optional<Person> findByFullName(String firstName, String lastName );
}
