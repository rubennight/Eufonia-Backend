package com.eufonia.eufonia_backend.api.pago;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.eufonia.eufonia_backend.api.cita.Cita;
import com.eufonia.eufonia_backend.api.proyecto.ProyectoMusical;

import lombok.Data;

@Data
public class HistorialPago {

    private UUID idHistorialPago;

    private ProyectoMusical proyectoMusical;

    private Cita cita;

    private BigDecimal monto;

    private LocalDate fecha;

    private String metodoPago;
}
