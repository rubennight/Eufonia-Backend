package com.eufonia.eufonia_backend.api.cita;

import com.eufonia.eufonia_backend.api.servicio.Servicio;

import lombok.Data;

@Data
public class CitaServicio {
    
    private Cita cita;
    
    private Servicio servicio;
}
