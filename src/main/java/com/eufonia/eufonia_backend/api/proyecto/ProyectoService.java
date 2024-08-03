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

            proyectosMusicales = ProyectoFactory.toListObject(proyectoEntities);

        } catch (Exception e) {
            e.getStackTrace();
        }

        return proyectosMusicales;
    }

    public Boolean agregarProyecto(ProyectoMusical proyectoMusical){
        try{
            ProyectoEntity proyectoEntity = ProyectoFactory.toEntity(proyectoMusical);

            proyectoRepository.save(proyectoEntity);

            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
