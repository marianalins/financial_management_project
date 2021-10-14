package com.example.projeto_mariana.service;

import com.example.projeto_mariana.model.DocumentType;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DocumentTypeService {
    DocumentType getDocumentType(Long id);
    Optional<DocumentType> findDocumentType(DocumentType documentType);
    void addDocumentType(DocumentType documentType);
    void delete(Long id);
    ResponseEntity<DocumentType> update(Long id, DocumentType documentTypeInfo);
    List<DocumentType> list();
}
