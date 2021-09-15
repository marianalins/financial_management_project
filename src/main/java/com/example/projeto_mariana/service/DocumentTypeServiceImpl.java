package com.example.projeto_mariana.service;

import com.example.projeto_mariana.model.DocumentType;
import com.example.projeto_mariana.repository.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class DocumentTypeServiceImpl {

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    public DocumentType getDocumentType(Long id){
        return documentTypeRepository.findById(id).orElse(null);
    }

    public DocumentType findDocumentType(DocumentType documentType){
        List<DocumentType> listDocumentType = list();
        for(int i = 0; i <= listDocumentType.size() - 1 ;i++) {
            if(listDocumentType.get(i).getDescription().equals(documentType.getDescription()) &&
                    listDocumentType.get(i).getExtension().equals(documentType.getExtension())) {
                return documentType;
            }
        }
        return null;
    }

    public ResponseEntity<DocumentType> update(Long id, DocumentType documentTypeInfo) {
        DocumentType documentType =  documentTypeRepository.findById(id).orElse(null);
        documentType.setDescription(documentTypeInfo.getDescription());
        documentType.setExtension(documentTypeInfo.getExtension());
        return ResponseEntity.ok(documentTypeRepository.save(documentType));
    }

    public void addDocumentType(DocumentType documentType){
        documentTypeRepository.save(documentType);
    }

    public List<DocumentType> list(){
        return documentTypeRepository.findAll();
    }
}
