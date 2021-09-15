package com.example.projeto_mariana.controller;

import com.example.projeto_mariana.model.DocumentType;
import com.example.projeto_mariana.model.Person;
import com.example.projeto_mariana.service.DocumentTypeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/documentType")
@Slf4j
public class DocumentTypeController {

    private DocumentTypeService documentTypeService;

    @GetMapping("/get/documentType")
    public ResponseEntity<?> getDocumentType(@PathVariable Long id){
        log.info("Receiving HTTP request ");
        Optional<DocumentType> optional = Optional.ofNullable(documentTypeService.getDocumentType(id));
        if(optional.isPresent()) {
            return new ResponseEntity<DocumentType>(optional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Document type does not exist in the system", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addDocumentType(@RequestBody DocumentType documentType){
        log.info("Receiving HTTP request ");
        Optional<DocumentType> optional = Optional.ofNullable(documentTypeService.findDocumentType(documentType));

        if(!optional.isPresent()) {
            documentTypeService.addDocumentType(documentType);
            return new ResponseEntity<>("Document added successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Document already exist in the system", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = {"/delete/{id}"})
    public ResponseEntity<String> delete(@PathVariable Long id) {
        log.info("Receiving HTTP request ");
        Optional<DocumentType> optional = Optional.ofNullable(documentTypeService.getDocumentType(id));
        if(optional.isPresent()) {
            documentTypeService.delete(id);
            return new ResponseEntity<>("Document deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Document does not exist in the system", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable(value="id") Long id, DocumentType documentTypeInfo) {
        log.info("Receiving HTTP request ");
        return new ResponseEntity<>("Updated successfully "+ documentTypeService.update(id,documentTypeInfo),HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<DocumentType>> list() {
        log.info("Receiving HTTP request ");

        return ResponseEntity.ok(documentTypeService.list());

    }
}
