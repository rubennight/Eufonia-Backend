package com.eufonia.eufonia_backend.api.proyecto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("proyectoMusical")
public class ProyectoController {
    
    @Autowired
    private ProyectoService proyectoService;

    @GetMapping("listaDeProyectosMusicales")
    public List<ProyectoMusical> obtenerListaDeProyectosMusicales() {
        return proyectoService.obtenerTodosLosProyectos();
    }

    @GetMapping("agregarProyectoMusical")
    public boolean agregarProyectoMusical(@RequestBody ProyectoMusical proyectoMusical) {
        return proyectoService.agregarProyecto(proyectoMusical);
    }
    
}
