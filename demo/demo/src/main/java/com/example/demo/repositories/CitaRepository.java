package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.CitaModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends CrudRepository<CitaModel, Long> {
    public abstract ArrayList<CitaModel> findByPrioridad(Integer prioridad);

}