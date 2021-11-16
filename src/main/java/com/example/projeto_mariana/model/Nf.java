package com.example.projeto_mariana.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="nf")
public class Nf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long id;
    @Column(name = "document")
    public String document;
    @Column(name = "number", nullable = false)
    public String number;
    @Column(name = "document_type_id", nullable = false)
    public Long documentTypeId;

    public Nf(Long id, String number) {
        this.id = id;
        this.number = number;
    }

}
