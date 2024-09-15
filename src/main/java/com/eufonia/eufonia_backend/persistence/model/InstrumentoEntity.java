package com.eufonia.eufonia_backend.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class InstrumentoEntity {
    
    @Id
    @Column(name = "id_instrumento")
    private Integer idInstrumento;

    @Column(name = "descripcion")
    private String descricpion;
}
