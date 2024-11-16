package com.eufonia.eufonia_backend.api.catalogos.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eufonia.eufonia_backend.persistence.model.ServicioEntity;
import com.eufonia.eufonia_backend.persistence.repository.ServicioRepository;

@Service
public class ServicioService {
    
    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> obtenerTodosLosServicios(){
        List<ServicioEntity> servicioEntities = servicioRepository.findAll();
        List<Servicio> servicios = new ArrayList<>();

        for (ServicioEntity servicioEntity : servicioEntities) {
            Servicio servicio = ServicioFactory.toObject(servicioEntity);
            servicios.add(servicio);
        }

        return servicios;
    }

    public Boolean agregarServicio(Servicio servicio){
        try {
            ServicioEntity servicioEntity = ServicioFactory.toEntity(servicio);
            servicioRepository.save(servicioEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
