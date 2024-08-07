package com.eufonia.eufonia_backend.api.proyecto;

import java.util.UUID;

import lombok.Data;

@Data
public class ProyectoMusical {
    
    private UUID idProyecto;

    private String nombre;

    private Integer instrumentos;

    private String email;

    private String telefono;

    private String descripcion;

    private String generoMusical;

    private String password;
    
}
