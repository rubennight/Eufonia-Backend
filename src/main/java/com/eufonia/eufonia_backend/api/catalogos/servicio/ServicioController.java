package com.eufonia.eufonia_backend.api.catalogos.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("servicio")
public class ServicioController {
    
    @Autowired
    private ServicioService servicioService;

    @GetMapping("listaDeServicios")
    public List<Servicio> obtenerListaDeServicios() {
        return servicioService.obtenerTodosLosServicios();
    }

    @PostMapping("agregarServicio")
    public Boolean agregarServicio(@RequestBody Servicio servicio) {        
        return servicioService.agregarServicio(servicio);
    }
    
    
}
