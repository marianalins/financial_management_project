package com.example.projeto_mariana.service;

import com.example.projeto_mariana.model.Nf;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface NfService {
    Nf getNf(Long id);
    Optional<Nf> findNf(Nf nf);
    void addNf(Nf nf);
    void delete(Long id);
    Nf update(Long id, Nf nfInfo);
    List<Nf> list();
}
