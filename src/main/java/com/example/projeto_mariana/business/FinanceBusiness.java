package com.example.projeto_mariana.business;

import com.example.projeto_mariana.model.Finance;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface FinanceBusiness {
    public Finance getFinance(Long id);
    public void addFinance(Finance finance);
    public void delete(Long id);
    public ResponseEntity<Finance> update(Long id, Finance financeInfo);
    public List<Finance> list();
}
