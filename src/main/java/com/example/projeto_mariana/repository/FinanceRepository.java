package com.example.projeto_mariana.repository;

import com.example.projeto_mariana.model.Finance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FinanceRepository extends JpaRepository<Finance,Long> {

    @Query("select f from Finance f where f.personId = ?1 and f.type = ?2 and f.nfId = ?3")
    Optional<Finance> findByData(Long personId, String type, Long nfId);
}
