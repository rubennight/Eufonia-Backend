package com.eufonia.eufonia_backend.api.catalogos.promocion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eufonia.eufonia_backend.persistence.model.PromocionEntity;
import com.eufonia.eufonia_backend.persistence.repository.PromocionRepository;

@Service
public class PromocionService {
    
    @Autowired
    private PromocionRepository promocionRepository;

    List<Promocion> obtenerTodasLasPromociones(){

        List<PromocionEntity> promocionEntities = promocionRepository.findAll();

        List<Promocion> promociones = PromocionFactory.toListObject(promocionEntities);
        
        return promociones;
    }
}
