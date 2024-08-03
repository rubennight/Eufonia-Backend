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

    public Boolean agregarCita(Cita cita){
        CitaEntity citaEntity = CitaFactory.toEntity(cita);

        ProyectoEntity proyectoEntity = proyectoRepository.getReferenceById(cita.getIdProyecto());
        PromocionEntity promocionEntity = promocionRepository.getReferenceById(cita.getIdPromocion());
        try{
            if(proyectoEntity != null){
                citaEntity.setProyectoMusical(proyectoEntity);

                if(promocionEntity != null){
                    citaEntity.setPromocion(promocionEntity);
                }

                citaRepository.save(citaEntity);
                return true;
            } else {
                return false;
            }
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }

    
}
