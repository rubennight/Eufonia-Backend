package com.eufonia.eufonia_backend.api.promocion;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class Promocion {
    
    private UUID idPromocion;
    
    private String nombre;

    private String descripcion;

    private LocalDateTime fechaInicio;

    private LocalDateTime fechaFinal;

    private BigDecimal descuento;

    private Boolean vigencia;

}
