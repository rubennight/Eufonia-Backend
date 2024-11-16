package com.eufonia.eufonia_backend.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eufonia.eufonia_backend.persistence.model.ProyectoInstrumentoEntity;
import com.eufonia.eufonia_backend.persistence.model.ProyectoMusicalEntity;

import java.util.List;


public interface ProyectoInstrumentoRepository extends JpaRepository<ProyectoInstrumentoEntity, Integer> {
    List<ProyectoInstrumentoEntity> findByProyectoMusical(ProyectoMusicalEntity proyectoMusical);
}
