package com.eufonia.eufonia_backend.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eufonia.eufonia_backend.persistence.model.GeneroMusicalEntity;

public interface GeneroMusicalRepository extends JpaRepository<GeneroMusicalEntity, Integer> {
    
}
