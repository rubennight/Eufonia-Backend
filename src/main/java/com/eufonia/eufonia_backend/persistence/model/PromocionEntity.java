package com.eufonia.eufonia_backend.persistence.model;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "promocion", schema = "public")
public class PromocionEntity {
    
    @Id
    @Column(name = "id_promocion")
    private UUID idPromocion;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "instrumentos")
    private Integer instrumentos;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "vigencia")
    private boolean vigencia;

}
