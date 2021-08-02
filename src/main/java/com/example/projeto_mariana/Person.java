package com.example.projeto_mariana;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int id;

    @Column(name="first_name", nullable = false)
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    public Person(int id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }
}
