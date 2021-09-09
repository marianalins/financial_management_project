package com.example.projeto_mariana.controller;

import com.example.projeto_mariana.model.Finance;
import com.example.projeto_mariana.business.FinanceBusiness;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/finance")
@Slf4j
public class FinanceController {

    @Autowired
    private FinanceBusiness financeBusiness;

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getFinance(@PathVariable Long id) {
        log.info("Reveiving HTTP request ");
        Optional<Finance> finance = Optional.ofNullable(financeBusiness.getFinance(id));
        if(finance.isPresent()) {
            return new ResponseEntity<Finance>(finance.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Finance does not exist in the system", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> addFinance(@RequestBody Finance finance) {
        log.info("Receiving HTTP request ");
        Optional<Finance> optional = Optional.ofNullable(financeBusiness.findFinance(finance));
        if(!optional.isPresent()) {
            financeBusiness.addFinance(finance);
            return new ResponseEntity<>("Finance added successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Finance already exist in the system", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        log.info("Receiving HTTP request ");
        Optional<Finance> optional = Optional.ofNullable(financeBusiness.getFinance(id));
        if(optional.isPresent()) {
            financeBusiness.delete(id);
            return new ResponseEntity<>("Finance deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Finance does not exist in the system", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable(value="id") Long id, Finance finance) {
        log.info("Receiving HTTP request ");
        return new ResponseEntity<>("Updated successfully "+financeBusiness.update(id,finance),HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Finance>> list() {
        log.info("Receiving HTTP request ");
        return ResponseEntity.ok(financeBusiness.list());

    }

}
