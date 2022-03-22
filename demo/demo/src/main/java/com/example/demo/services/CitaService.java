package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.CitaModel;
import com.example.demo.repositories.CitaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitaService {
    @Autowired
    CitaRepository citaRepository;
    
    public ArrayList<CitaModel> obtenerCitas(){
        return (ArrayList<CitaModel>) citaRepository.findAll();
    }

    public CitaModel guardarCita(CitaModel usuario){
        return citaRepository.save(usuario);
    }

    public Optional<CitaModel> obtenerPorId(Long id){
        return citaRepository.findById(id);
    }


    public ArrayList<CitaModel>  obtenerPorPrioridad(Integer prioridad) {
        return citaRepository.findByPrioridad(prioridad);
    }

    public boolean eliminarCita(Long id) {
        try{
            citaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


    
}