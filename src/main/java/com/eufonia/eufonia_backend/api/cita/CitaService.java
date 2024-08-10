package com.eufonia.eufonia_backend.api.cita;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eufonia.eufonia_backend.persistence.model.CitaEntity;
import com.eufonia.eufonia_backend.persistence.model.CitaServicioEntity;
import com.eufonia.eufonia_backend.persistence.model.PromocionEntity;
import com.eufonia.eufonia_backend.persistence.model.ProyectoEntity;
import com.eufonia.eufonia_backend.persistence.repository.CitaRepository;
import com.eufonia.eufonia_backend.persistence.repository.CitaServicioRepository;
import com.eufonia.eufonia_backend.persistence.repository.PromocionRepository;
import com.eufonia.eufonia_backend.persistence.repository.ProyectoRepository;

@Service
public class CitaService {

    @Autowired
    private CitaServicioRepository citaServicioRepository;
    
    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private PromocionRepository promocionRepository;

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
