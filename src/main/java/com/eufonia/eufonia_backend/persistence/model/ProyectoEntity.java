package com.eufonia.eufonia_backend.persistence.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "proyecto")
public class ProyectoEntity {
    
    @Id
    @Column(name = "id_proyecto")
    private UUID idProyecto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "instrumentos")
    private Integer instrumentos;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String descripcion;

    @Column(name = "genero_musical")
    private String generoMusical;
    
}
