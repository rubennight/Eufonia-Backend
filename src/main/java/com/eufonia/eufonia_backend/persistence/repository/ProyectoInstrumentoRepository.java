package com.eufonia.eufonia_backend.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eufonia.eufonia_backend.persistence.model.ProyectoInstrumentoEntity;

public interface ProyectoInstrumentoRepository extends JpaRepository<ProyectoInstrumentoEntity, Integer> {
    
}