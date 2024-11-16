package com.eufonia.eufonia_backend.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "instrumentos")
public class InstrumentoEntity {
    
    @Id
    @Column(name = "id_instrumento")
    private Integer idInstrumento;

    @Column(name = "descripcion")
    private String descricpion;
}
