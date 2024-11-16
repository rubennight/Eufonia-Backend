package com.eufonia.eufonia_backend.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eufonia.eufonia_backend.persistence.model.ProyectoGeneroEntity;
import com.eufonia.eufonia_backend.persistence.model.ProyectoMusicalEntity;

import java.util.List;


public interface ProyectoGeneroRepository extends JpaRepository<ProyectoGeneroEntity, Integer> {
    List<ProyectoGeneroEntity> findByProyectoMusicalEntity(ProyectoMusicalEntity proyectoMusicalEntity);
}
