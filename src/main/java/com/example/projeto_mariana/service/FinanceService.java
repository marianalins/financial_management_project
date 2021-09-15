package com.example.projeto_mariana.service;

import com.example.projeto_mariana.model.Finance;

import java.util.List;

public interface FinanceService {
    public Finance getFinance(Long id);
    public Finance findFinance(Finance finance);
    public void addFinance(Finance finance);
    public void delete(Long id);
    public Finance update(Long id, Finance financeInfo);
    public List<Finance> list();
}
