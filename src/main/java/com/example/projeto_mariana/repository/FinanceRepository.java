package com.example.projeto_mariana.repository;

import com.example.projeto_mariana.model.Finance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceRepository extends JpaRepository<Finance,Long> {
}
