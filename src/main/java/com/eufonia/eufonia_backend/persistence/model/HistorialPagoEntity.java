package com.eufonia.eufonia_backend.persistence.model;

import java.math.BigDecimal;
import java.time.LocalDate;
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
@Table(name = "historial_pago")
public class HistorialPagoEntity {
    
    @Id
    @Column(name = "id_historial_pago")
    private UUID idHistorialPago;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "id_cita")
    private CitaEntity cita;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "metodo_pago")
    private String metodoPago;
}
