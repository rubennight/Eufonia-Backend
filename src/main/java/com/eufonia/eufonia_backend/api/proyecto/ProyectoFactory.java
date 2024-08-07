package com.eufonia.eufonia_backend.api.proyecto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.eufonia.eufonia_backend.persistence.model.ProyectoEntity;

public class ProyectoFactory {
    
    public static List<ProyectoMusical> toListObject(List<ProyectoEntity> proyectoEntities){
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

    public static ProyectoEntity toEntity(ProyectoMusical proyectoMusical){
        ProyectoEntity proyectoEntity = new ProyectoEntity();

        UUID idProyecto = UUID.randomUUID();

        proyectoEntity.setIdProyecto(idProyecto);
        proyectoEntity.setNombre(proyectoMusical.getNombre());
        proyectoEntity.setTelefono(proyectoMusical.getTelefono());
        proyectoEntity.setDescripcion(proyectoMusical.getDescripcion());
        proyectoEntity.setInstrumentos(proyectoMusical.getInstrumentos());
        proyectoEntity.setEmail(proyectoMusical.getEmail());
        proyectoEntity.setGeneroMusical(proyectoMusical.getGeneroMusical());
        proyectoEntity.setPassword(proyectoMusical.getPassword());

        return proyectoEntity;
    }
}
