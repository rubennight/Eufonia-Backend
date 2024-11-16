package com.eufonia.eufonia_backend.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "proyecto_genero")
public class ProyectoGeneroEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyecto_genero")
    private Integer idProyectoGenero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_genero_musical")
    private GeneroMusicalEntity genero;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proyecto_musical")
    private ProyectoMusicalEntity proyectoMusicalEntity;
}
