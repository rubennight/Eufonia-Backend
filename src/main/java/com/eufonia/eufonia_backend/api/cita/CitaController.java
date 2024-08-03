package com.eufonia.eufonia_backend.api.cita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("cita")
public class CitaController {
    
    @Autowired
    private CitaService citaService;

    @PostMapping("agregarCita")
    public Boolean agregarCita(Cita cita) {
        return citaService.agregarCita(cita);
    }
    
}
