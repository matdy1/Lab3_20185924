package com.example.lab3.repository;

import com.example.lab3.entity.Estadio;
import com.example.lab3.entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadioRepositorio extends JpaRepository<Estadio,Integer> {
}
