package com.example.lab3.controllers;

import com.example.lab3.entity.Estadio;
import com.example.lab3.entity.Jugador;
import com.example.lab3.repository.EstadioRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

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

    @GetMapping(value="/estadio/nuevo")
    public String nuevaDistribuidora(){
        return "/estadios/nuevo";
    }

    @PostMapping(value = "/estadio/guardar")
    public String guardarDistribuidora( Estadio estadio){

        estadioRepositorio.save(estadio);
        return "redirect:/lab3/estadio/lista";
    }

    @GetMapping("/estadio/borrar")
    public String borrar(@RequestParam("id") int id) {

        Optional<Estadio> optional = estadioRepositorio.findById(id);

        if (optional.isPresent()) {
            estadioRepositorio.deleteById(id);
        }

        return "redirect:/lab3/estadio/lista";
    }
}
