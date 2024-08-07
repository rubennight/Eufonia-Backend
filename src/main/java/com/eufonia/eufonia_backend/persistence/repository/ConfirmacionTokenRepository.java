package com.eufonia.eufonia_backend.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eufonia.eufonia_backend.persistence.model.ConfirmacionTokenEntity;


public interface ConfirmacionTokenRepository extends JpaRepository<ConfirmacionTokenEntity, UUID> {
    Optional<ConfirmacionTokenEntity> findByToken(String token);
}
