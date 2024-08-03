package com.eufonia.eufonia_backend.api.servicio;

import java.util.UUID;

import com.eufonia.eufonia_backend.persistence.model.ServicioEntity;

public class ServicioFactory {
    
    public static Servicio toObject(ServicioEntity servicioEntity){
        Servicio servicio = new Servicio();

        servicio.setIdServicio(servicioEntity.getIdServicio());
        servicio.setNombre(servicioEntity.getNombre());
        servicio.setDescripcion(servicioEntity.getDescripcion());
        servicio.setPrecio(servicioEntity.getPrecio());

        return servicio;
    }

    public static ServicioEntity toEntity(Servicio servicio){
        ServicioEntity servicioEntity = new ServicioEntity();
        UUID idServicio = UUID.randomUUID();

        servicioEntity.setIdServicio(idServicio);
        servicioEntity.setNombre(servicio.getNombre());
        servicioEntity.setDescripcion(servicio.getDescripcion());
        servicioEntity.setPrecio(servicio.getPrecio());

        return servicioEntity;
    }
}
