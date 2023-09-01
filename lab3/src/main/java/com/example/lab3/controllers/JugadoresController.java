package com.example.lab3.controllers;

import com.example.lab3.entity.Jugador;
import com.example.lab3.repository.JuegodorRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class JugadoresController {

    final JuegodorRepositorio juegodorRepositorio;

    public JugadoresController(JuegodorRepositorio juegodorRepositorio) {
        this.juegodorRepositorio = juegodorRepositorio;
    }


    @GetMapping(value="/jugadores/lista")
    public String listaJugadores (Model model){

        model.addAttribute("lista", juegodorRepositorio.findAll());
        return "/jugadores/lista";
    }

    @GetMapping(value="/jugadores/nuevo")
    public String nuevaDistribuidora(){
        return "/jugadores/nuevo";
    }

    @PostMapping(value = "/distribuidoras/guardar")
    public String guardarDistribuidora( Jugador jugador){

        juegodorRepositorio.save(jugador);
        return "redirect:/distribuidoras/lista";
    }


    @GetMapping("/jugadores/borrar")
    public String borrar(@RequestParam("id") int id) {

        Optional<Jugador> optional = juegodorRepositorio.findById(id);

        if (optional.isPresent()) {
            juegodorRepositorio.deleteById(id);
        }

        return "redirect:/lab3/jugadores/lista";
    }
}
