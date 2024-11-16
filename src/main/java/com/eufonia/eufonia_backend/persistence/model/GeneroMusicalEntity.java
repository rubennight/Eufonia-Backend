package com.eufonia.eufonia_backend.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "genero_musical")
public class GeneroMusicalEntity {
    
    @Id
    @Column(name = "id_genero_musical")
    private Integer idGeneroMusical;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;
    
}
