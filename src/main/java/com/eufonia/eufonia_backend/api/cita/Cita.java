package com.eufonia.eufonia_backend.api.cita;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;

@Data
public class Cita {
    
    private UUID idCita;

    private Integer idProyecto;

    private UUID idPromocion;

    private LocalDate fechaHora;

    private String telefono;

    private Boolean vigencia;
    
}
