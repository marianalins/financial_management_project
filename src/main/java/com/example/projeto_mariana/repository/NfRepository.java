package com.example.projeto_mariana.repository;

import com.example.projeto_mariana.model.Nf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface NfRepository extends JpaRepository<Nf, Long> {

    @Query("select n from Nf n where n.number = ?1")
    Optional<Nf> findByNumber(String number);
}
