package com.example.lab3.controllers;

import com.example.lab3.repository.EstadioRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EstadioControllers {

    final EstadioRepositorio estadioRepositorio;

    public EstadioControllers(EstadioRepositorio estadioRepositorio) {
        this.estadioRepositorio = estadioRepositorio;
    }


    @GetMapping(value="/estadio/lista")
    public String listaJugadores (Model model){

        model.addAttribute("lista", estadioRepositorio.findAll());
        return "/estadios/lista";
    }
}
