package com.eufonia.eufonia_backend.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eufonia.eufonia_backend.persistence.model.InstrumentoEntity;

public interface InstrumentoRepository extends JpaRepository<InstrumentoEntity, Integer> {
    
} 
