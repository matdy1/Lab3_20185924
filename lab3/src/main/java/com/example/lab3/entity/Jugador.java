package com.example.lab3.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "jugador")
@Getter
@Setter
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJugador;

    @Column(nullable = false,length = 45)
    private String nombre;

    @Column(nullable = false)
    private Integer edad;

    @Column(nullable = false,length = 45)
    private String posicion;

    @Column(nullable = false,length = 45)
    private String club;

    @Column(nullable = false)
    private Integer sn_idSeleccion;
}
