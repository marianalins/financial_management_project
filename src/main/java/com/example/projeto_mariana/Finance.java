package com.example.projeto_mariana;

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
    public int id;
    @Column(name="type", nullable = false)
    public String type;
    @Column(name="description")
    public String description;
    @Column(name="person_id", nullable = false)
    public int personId;
    @Column(name="date")
    public Date date;
    @Column(name="due_date")
    public Date dueDate;
    @Column(name="nf_id", nullable = false)
    public int nfId;

    public Finance(int id, String type, int personId, int nfId) {
        this.id = id;
        this.type = type;
        this.personId = personId;
        this.nfId = nfId;
    }
}
