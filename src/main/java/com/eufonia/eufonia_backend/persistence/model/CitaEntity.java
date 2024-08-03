package com.eufonia.eufonia_backend.persistence.model;

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
@Table(name = "cita")
public class CitaEntity {

    @Id
    @Column(name = "id_cita")
    private UUID idCita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proyecto")
    private ProyectoEntity proyectoMusical;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_promocion")
    private PromocionEntity promocion;

    @Column(name = "fecha_hora")
    private LocalDate fechaHora;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "vigencia")
    private Boolean vigencia;

}
