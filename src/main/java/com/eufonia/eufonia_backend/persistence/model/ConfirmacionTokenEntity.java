package com.eufonia.eufonia_backend.persistence.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "confirmacion_token")
public class ConfirmacionTokenEntity {
    
    @Id
    @Column(name = "id_confirmacion_token")
    private UUID idConfirmacionToken;

    @Column(name = "token")
    private String token;

    @Column(name = "expiracion")
    private LocalDateTime expiracion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proyecto_musical")
    private ProyectoMusicalEntity proyectoMusical;
    
}
