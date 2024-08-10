package com.eufonia.eufonia_backend.api.cita;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eufonia.eufonia_backend.api.servicio.Servicio;
import com.eufonia.eufonia_backend.persistence.model.CitaEntity;
import com.eufonia.eufonia_backend.persistence.model.CitaServicioEntity;
import com.eufonia.eufonia_backend.persistence.model.ServicioEntity;
import com.eufonia.eufonia_backend.persistence.repository.ServicioRepository;

public class CitaServicioFactory {

    @Autowired
    private static ServicioRepository servicioRepository;
    
    public static List<CitaServicioEntity> toListEntity(CitaServicio citaServicio){
        CitaEntity citaEntity = CitaFactory.toEntity(citaServicio.getCita());
        List<CitaServicioEntity> citasYServicios = new ArrayList<>();

        for (Servicio servicio : citaServicio.getServicios()) {
            CitaServicioEntity citaServicioEntity = new CitaServicioEntity();
            ServicioEntity servicioEntity = servicioRepository.getReferenceById(servicio.getIdServicio());

            citaServicioEntity.setCita(citaEntity);
            citaServicioEntity.setServicio(servicioEntity);

            citasYServicios.add(citaServicioEntity);
        }

        return citasYServicios;
    }
}
