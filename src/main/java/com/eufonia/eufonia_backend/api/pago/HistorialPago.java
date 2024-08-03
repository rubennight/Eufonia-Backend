package com.eufonia.eufonia_backend.api.pago;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.eufonia.eufonia_backend.persistence.model.CitaEntity;
import com.eufonia.eufonia_backend.persistence.model.ProyectoEntity;

import lombok.Data;

@Data
public class HistorialPago {

    private UUID idHistorialPago;

    private ProyectoEntity proyectoMusical;

    private CitaEntity cita;

    private BigDecimal monto;

    private LocalDate fecha;

    private String metodoPago;
}
