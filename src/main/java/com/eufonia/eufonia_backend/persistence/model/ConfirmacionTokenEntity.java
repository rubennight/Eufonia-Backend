package com.eufonia.eufonia_backend.persistence.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "confirmacion_token")
public class ConfirmacionTokenEntity {
    
    @Id
    @Column(name = "id_token")
    private UUID idToken;

    @Column(name = "token")
    private String token;


    @Column(name = "expiracion")
    private LocalDateTime expiracion;
    
}
