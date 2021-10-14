package com.example.projeto_mariana.service;

import com.example.projeto_mariana.model.DocumentType;
import com.example.projeto_mariana.repository.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class DocumentTypeServiceImpl {

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    public DocumentType getDocumentType(Long id){
        return documentTypeRepository.findById(id).orElse(null);
    }

    public Optional<DocumentType> findDocumentType(DocumentType documentType){
        return documentTypeRepository.findDocumentType(documentType.getId(),documentType.getDescription(),documentType.getExtension());
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
