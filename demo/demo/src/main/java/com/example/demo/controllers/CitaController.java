package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.CitaModel;
import com.example.demo.services.CitaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuario")
public class CitaController {
    @Autowired
    CitaService citaService;

    @GetMapping()
    public ArrayList<CitaModel> obtenerCita(){
        return citaService.obtenerCitas();
    }

    @PostMapping()
    public CitaModel guardarCita(@RequestBody CitaModel usuario){
        return this.citaService.guardarCita(usuario);
    }

    @GetMapping( path = "/{id}")
    public Optional<CitaModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.citaService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<CitaModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.citaService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.citaService.eliminarCita(id);
        if (ok){
            return "Se eliminó la Cita con id " + id;
        }else{
            return "No pudo eliminar la Cita con id" + id;
        }
    }

}

