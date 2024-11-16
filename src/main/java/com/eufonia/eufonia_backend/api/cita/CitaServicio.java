package com.eufonia.eufonia_backend.api.cita;

import java.util.List;

import com.eufonia.eufonia_backend.api.catalogos.servicio.Servicio;

import lombok.Data;

@Data
public class CitaServicio {
    
    private Cita cita;
    
    private List<Servicio> servicios;
}
