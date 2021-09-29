package com.example.projeto_mariana.service;

import com.example.projeto_mariana.model.Finance;
import com.example.projeto_mariana.repository.FinanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FinanceServiceImpl implements FinanceService {

    @Autowired
    private FinanceRepository financeRepository;

    public Finance getFinance(Long id) {
        return financeRepository.findById(id).orElse(null);
    }

    public Optional<Finance> findFinance(Finance finance){
        return financeRepository.findByData(finance.getPersonId(),finance.getType(),finance.getNfId());
    }

    public void addFinance(Finance finance) {
        financeRepository.save(finance);
    }

    public void delete(Long id) {
        financeRepository.deleteById(id);
    }

    public Finance update(Long id, Finance financeInfo) {
        Finance finance = financeRepository.findById(id).orElse(null);
        finance.setType(financeInfo.getType());
        finance.setPersonId(finance.getPersonId());
        finance.setNfId(finance.getNfId());
        finance.setDescription(finance.getDescription());
        finance.setDate(finance.getDate());
        finance.setDueDate(finance.getDueDate());
        return financeRepository.save(finance);
    }

    public List<Finance> list() {
        return financeRepository.findAll();
    }


}
