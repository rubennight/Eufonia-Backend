package com.eufonia.eufonia_backend.api.proyecto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eufonia.eufonia_backend.persistence.model.ProyectoMusicalEntity;
import com.eufonia.eufonia_backend.persistence.repository.ProyectoMusicalRepository;
import com.eufonia.eufonia_backend.util.ProyectoMusicalFactory;

public class ProyectoService {
    
    @Autowired
    private ProyectoMusicalRepository proyectoMusicalRepository;

    @Autowired
    private ProyectoMusicalFactory proyectoMusicalFactory;

    public List<ProyectoMusical> obtenerTodosLosProyectos() {
        List<ProyectoMusicalEntity> proyectoMusicalEntities = proyectoMusicalRepository.findAll();
        List<ProyectoMusical> proyectosMusicales = proyectoMusicalFactory.toObjects(proyectoMusicalEntities);
        return proyectosMusicales;
    }

    public boolean registrarProyecto(AgregarProyectoMusical proyectoMusical) {
        
    }

    public ProyectoMusical confirmarRegistro(String token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'confirmarRegistro'");
    }
    
}
