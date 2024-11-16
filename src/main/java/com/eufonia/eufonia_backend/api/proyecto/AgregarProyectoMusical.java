package com.eufonia.eufonia_backend.api.proyecto;

import java.util.List;

import lombok.Data;

@Data
public class AgregarProyectoMusical {

    private String nombre;

    private String telefono;    

    private String descripcion;

    private List<Integer> generoMusical;

    private List<Integer> instrumentos;

    private String email;

    private String password;
}
