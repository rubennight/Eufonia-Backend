package com.eufonia.eufonia_backend.api.proyecto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("proyectoMusical")
public class ProyectoController {
    
    @Autowired
    private ProyectoService proyectoService;

    @GetMapping("listaDeProyectosMusicales")
    public List<ProyectoMusical> getMethodName() {
        return proyectoService.obtenerTodosLosProyectos();
    }
    
}
