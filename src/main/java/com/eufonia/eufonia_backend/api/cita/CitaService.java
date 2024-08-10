package com.eufonia.eufonia_backend.api.cita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eufonia.eufonia_backend.persistence.model.CitaEntity;
import com.eufonia.eufonia_backend.persistence.model.PromocionEntity;
import com.eufonia.eufonia_backend.persistence.model.ProyectoEntity;
import com.eufonia.eufonia_backend.persistence.repository.CitaRepository;
import com.eufonia.eufonia_backend.persistence.repository.PromocionRepository;
import com.eufonia.eufonia_backend.persistence.repository.ProyectoRepository;

@Service
public class CitaService {
    
    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private PromocionRepository promocionRepository;

    public Boolean agregarCita(CitaServicio citaServicio){
        
        try{
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }

}
