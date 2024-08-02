package com.eufonia.eufonia_backend.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eufonia.eufonia_backend.persistence.model.ProyectoEntity;

public interface ProyectoRepository extends JpaRepository<ProyectoEntity, UUID>{
    
}
