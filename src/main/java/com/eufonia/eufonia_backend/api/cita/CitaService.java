package com.eufonia.eufonia_backend.api.cita;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eufonia.eufonia_backend.persistence.model.CitaServicioEntity;
import com.eufonia.eufonia_backend.persistence.repository.CitaServicioRepository;

@Service
public class CitaService {

    @Autowired
    private CitaServicioRepository citaServicioRepository;

    public Boolean agregarCita(CitaServicio citaServicio){
        List<CitaServicioEntity> citaYServicios = CitaServicioFactory.toListEntity(citaServicio);

        try{
            for (CitaServicioEntity citaServicioEntity : citaYServicios) {
                citaServicioRepository.save(citaServicioEntity);
            }
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }

}
