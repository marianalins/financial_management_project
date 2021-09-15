package com.example.projeto_mariana.service;

import com.example.projeto_mariana.model.Nf;
import com.example.projeto_mariana.repository.NfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NfServiceImpl implements NfService {

    @Autowired
    private NfRepository nfRepository;

    public Nf getNf(Long id){
        return nfRepository.findById(id).orElse(null);
    }

    public Nf findNf(Nf nf){
        List<Nf> nfList = list();
        for(int i = 0; i <= nfList.size(); i++) {
            if(nfList.get(i).getNumber().equals(nf.getNumber())) {
                return nf;
            }
        }
        return null;
    }

    public void addNf(Nf nf){
        nfRepository.save(nf);
    }
    public void delete(Long id){
        nfRepository.deleteById(id);
    }

    public Nf update(Long id, Nf nfInfo){
        Nf nf = nfRepository.findById(id).orElse(null);
        nf.setNumber(nfInfo.getNumber());
        nf.setDocument(nfInfo.getDocument());
        nf.setDocumentTypeId(nfInfo.getDocumentTypeId());
        return nfRepository.save(nf);
    }

    public List<Nf> list(){
        return nfRepository.findAll();
    }

}
