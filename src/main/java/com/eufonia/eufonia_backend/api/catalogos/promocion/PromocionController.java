package com.eufonia.eufonia_backend.api.catalogos.promocion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("promocion")
public class PromocionController {
    
    @Autowired
    private PromocionService promocionService;

    @GetMapping("listaDePromociones")
    public List<Promocion> obtenerListaDePromociones() {
        return promocionService.obtenerTodasLasPromociones();
    }
    
}
