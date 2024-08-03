package com.eufonia.eufonia_backend.api.cita;

import java.util.UUID;

import com.eufonia.eufonia_backend.persistence.model.CitaEntity;

public class CitaFactory {
    
    public static CitaEntity toEntity(Cita cita){
        CitaEntity citaEntity = new CitaEntity();
        UUID idCita = UUID.randomUUID();

        citaEntity.setIdCita(idCita);
        citaEntity.setFechaHora(cita.getFechaHora());
        citaEntity.setTelefono(cita.getTelefono());
        citaEntity.setVigencia(cita.getVigencia());
        
        return citaEntity;
    }
}
