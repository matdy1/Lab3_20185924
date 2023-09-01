package com.example.lab3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "estadio")
@Getter
@Setter
public class Estadio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstadio;

    @Column(nullable = false,length = 45)
    private String nombre;

    @Column(nullable = false,length = 45)
    private String provincia;

    @Column(length = 45)
    private String club;

}
