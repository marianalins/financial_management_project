package com.example.projeto_mariana.controller;

import com.example.projeto_mariana.model.Finance;
import com.example.projeto_mariana.business.FinanceBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/finance")
@Slf4j
public class FinanceController {

    @Autowired
    private FinanceBusiness financeBusiness;

    public void getFinance() {
        log.info("Reveiving HTTP request ");
    }

    @GetMapping("/list")
    public ResponseEntity<List<Finance>> list() {
        log.info("Receiving HTTP request ");
        //final Finance finance = new Finance ();
        return ResponseEntity.ok(new ArrayList<Finance>());

    }

}
