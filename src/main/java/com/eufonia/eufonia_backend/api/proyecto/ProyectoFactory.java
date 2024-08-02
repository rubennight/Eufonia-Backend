package com.eufonia.eufonia_backend.api.proyecto;

import java.util.ArrayList;
import java.util.List;

import com.eufonia.eufonia_backend.persistence.model.ProyectoEntity;

public class ProyectoFactory {
    
    public static List<ProyectoMusical> convertirEntityAObjeto(List<ProyectoEntity> proyectoEntities){
        List<ProyectoMusical> proyectosMusicales = new ArrayList<>();

        for (ProyectoEntity proyectoEntity : proyectoEntities) {
            ProyectoMusical proyectoMusical = new ProyectoMusical();

            proyectoMusical.setIdProyecto(proyectoEntity.getIdProyecto());
            proyectoMusical.setNombre(proyectoEntity.getNombre());
            proyectoMusical.setDescripcion(proyectoEntity.getDescripcion());
            proyectoMusical.setEmail(proyectoEntity.getEmail());
            proyectoMusical.setGeneroMusical(proyectoEntity.getGeneroMusical());

            proyectosMusicales.add(proyectoMusical);
        }

        return proyectosMusicales;
    }
}
