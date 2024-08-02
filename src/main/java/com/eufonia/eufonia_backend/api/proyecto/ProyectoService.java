package com.eufonia.eufonia_backend.api.proyecto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eufonia.eufonia_backend.persistence.model.ProyectoEntity;
import com.eufonia.eufonia_backend.persistence.repository.ProyectoRepository;

@Service
public class ProyectoService {
    
    @Autowired
    private ProyectoRepository proyectoRepository;

    public List<ProyectoMusical> obtenerTodosLosProyectos(){
        List<ProyectoMusical> proyectosMusicales = new ArrayList<>();

        try {
            List<ProyectoEntity> proyectoEntities = proyectoRepository.findAll();

            proyectosMusicales = ProyectoFactory.convertirEntityAObjeto(proyectoEntities);

        } catch (Exception e) {
            e.getStackTrace();
        }

        return proyectosMusicales;
    }
}
