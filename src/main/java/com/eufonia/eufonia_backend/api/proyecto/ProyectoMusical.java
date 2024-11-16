package com.eufonia.eufonia_backend.api.proyecto;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class ProyectoMusical {
    
    private UUID idProyecto;

    private String nombre;

    private String telefono;    

    private String descripcion;

    private List<String> generoMusical;

    private List<String> instrumentos;

    private String email;

    private String password;
    
}
