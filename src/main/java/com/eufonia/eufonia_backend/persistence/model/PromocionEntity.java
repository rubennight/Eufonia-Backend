package com.eufonia.eufonia_backend.persistence.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "promocion", schema = "public")
public class PromocionEntity {
    
    @Id
    @Column(name = "id_promocion")
    private UUID idPromocion;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDateTime fechaFin;

    @Column(name = "descuento")
    private BigDecimal descuento;

    @Column(name = "vigencia")
    private Boolean vigencia;
    
}
