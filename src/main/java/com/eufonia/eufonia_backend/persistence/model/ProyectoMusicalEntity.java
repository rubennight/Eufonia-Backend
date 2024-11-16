package com.eufonia.eufonia_backend.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class ProyectoMusicalEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyecto_musical")
    private Integer idProyectoMusical;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
