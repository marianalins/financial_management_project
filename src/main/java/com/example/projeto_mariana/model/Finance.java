package com.example.projeto_mariana.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "finance")
public class Finance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name="type", nullable = false)
    private String type;
    @Column(name="description")
    private String description;
    @Column(name="person_id", nullable = false)
    private int personId;
    @Column(name="date")
    private Date date;
    @Column(name="due_date")
    private Date dueDate;
    @Column(name="nf_id", nullable = false)
    private int nfId;

    public Finance(Long id, String type, int personId, int nfId) {
        this.id = id;
        this.type = type;
        this.personId = personId;
        this.nfId = nfId;
    }
}
