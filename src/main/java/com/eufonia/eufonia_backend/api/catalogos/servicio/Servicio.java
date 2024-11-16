package com.eufonia.eufonia_backend.api.catalogos.servicio;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Data;

@Data
public class Servicio {
    
    private UUID idServicio;

    private String nombre;

    private String descripcion;

    private BigDecimal precio;

}
