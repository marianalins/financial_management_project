package com.example.projeto_mariana.repository;

import com.example.projeto_mariana.model.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.Document;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {
}
