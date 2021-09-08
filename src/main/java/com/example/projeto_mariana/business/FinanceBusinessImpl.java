package com.example.projeto_mariana.business;

import com.example.projeto_mariana.model.Finance;
import com.example.projeto_mariana.repository.FinanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FinanceBusinessImpl implements FinanceBusiness{

    @Autowired
    private FinanceRepository financeRepository;

    public Finance getFinance(Long id) {
        return financeRepository.findById(id).orElse(null);
    }

    public List<Finance> list() {
        return financeRepository.findAll();
    }


}
