package com.example.projeto_mariana.business;

import com.example.projeto_mariana.model.Nf;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NfBusiness {
    public Nf getNf(Long id);
    public Nf findNf(Nf nf);
    public void addNf(Nf nf);
    public void delete(Long id);
    public Nf update(Long id, Nf nfInfo);
    public List<Nf> list();
}
