package com.example.projeto_mariana.controller;


import com.example.projeto_mariana.service.NfService;
import com.example.projeto_mariana.model.Nf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/nf")
@Slf4j
public class NfController {
    @Autowired
    private NfService nfService;

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getNf(@PathVariable Long id){
        log.info("Receiving HTTP request ");
        Optional<Nf> optional = Optional.ofNullable(nfService.getNf(id));
        if(optional.isPresent()) {
            return new ResponseEntity<Nf>(optional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Nf does not exist in the system", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addNf(@RequestBody Nf nf){
        log.info("Receiving HTTP request ");
        Optional<Nf> optional = nfService.findNf(nf);

        if(!optional.isPresent()) {
            nfService.addNf(nf);
            return new ResponseEntity<>("Nf added successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Nf already exist in the system", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        log.info("Receiving HTTP request ");
        Optional<Nf> optional = Optional.ofNullable(nfService.getNf(id));
        if(optional.isPresent()) {
            return new ResponseEntity<>("Nf deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Nf does not exist in the system",HttpStatus.OK);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable(value="id") Long id, Nf nfInfo) {
        log.info("Receiving HTTP request ");
        return new ResponseEntity<>("Updated successfully "+ nfService.update(id,nfInfo),HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Nf>> list(){
        log.info("Receiving HTTP request ");
        return ResponseEntity.ok(nfService.list());
    }
}
