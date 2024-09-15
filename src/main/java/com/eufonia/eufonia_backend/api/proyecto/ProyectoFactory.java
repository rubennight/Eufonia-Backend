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
        proyectoEntity.setEmail(proyectoMusical.getEmail());
        proyectoEntity.setPassword(proyectoMusical.getPassword());

        return proyectoEntity;
    }

    public static ProyectoMusical toObject(ProyectoEntity proyectoEntity){
        ProyectoMusical proyectoMusical = new ProyectoMusical();

        proyectoMusical.setIdProyecto(proyectoEntity.getIdProyecto());
        proyectoMusical.setNombre(proyectoEntity.getNombre());
        proyectoMusical.setEmail(proyectoEntity.getEmail());
        proyectoMusical.setTelefono(proyectoEntity.getTelefono());
        proyectoMusical.setDescripcion(proyectoEntity.getDescripcion());
        
        return proyectoMusical;
    }
}
