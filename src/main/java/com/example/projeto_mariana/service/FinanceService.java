package com.example.projeto_mariana.service;

import com.example.projeto_mariana.model.Finance;

import java.util.List;
import java.util.Optional;

public interface FinanceService {
    Finance getFinance(Long id);
    Optional<Finance> findFinance(Finance finance);
    void addFinance(Finance finance);
    void delete(Long id);
    Finance update(Long id, Finance financeInfo);
    List<Finance> list();
}
