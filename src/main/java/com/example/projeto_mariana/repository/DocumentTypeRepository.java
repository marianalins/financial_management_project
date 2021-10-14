package com.example.projeto_mariana.repository;

import com.example.projeto_mariana.model.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.Document;
import java.util.Optional;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {
    @Query("select dt from DocumentType dt where dt.id = ?1 and dt.description = ?2 and dt.extension")
    Optional<DocumentType> findDocumentType(Long id, String description, String extension);
}
