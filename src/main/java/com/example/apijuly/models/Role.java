package com.example.apijuly.models;

import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class Role {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }


    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private ERole name;

    public Role() {

    }
}
