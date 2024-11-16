package com.eufonia.eufonia_backend.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eufonia.eufonia_backend.api.proyecto.ProyectoMusical;
import com.eufonia.eufonia_backend.persistence.model.ProyectoGeneroEntity;
import com.eufonia.eufonia_backend.persistence.model.ProyectoInstrumentoEntity;
import com.eufonia.eufonia_backend.persistence.model.ProyectoMusicalEntity;
import com.eufonia.eufonia_backend.persistence.repository.ProyectoGeneroRepository;
import com.eufonia.eufonia_backend.persistence.repository.ProyectoInstrumentoRepository;

@Component
public class ProyectoMusicalFactory {

    @Autowired
    private ProyectoGeneroRepository proyectoGeneroRepository;

    @Autowired
    private ProyectoInstrumentoRepository proyectoInstrumentoRepository;
    
    public List<String> obtenerGeneros(ProyectoMusicalEntity proyectoMusicalEntity){
        List<String> generos = new ArrayList<>();        
        try {

            List<ProyectoGeneroEntity> generosPorProyecto = proyectoGeneroRepository.findByProyectoMusicalEntity(proyectoMusicalEntity);
            
            for (ProyectoGeneroEntity proyectoGeneroEntity : generosPorProyecto) {
                String genero = proyectoGeneroEntity.getGenero().getDescripcion();
                generos.add(genero);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return generos;
    }

    public List<String> obtenerInstrumentos(ProyectoMusicalEntity proyectoMusicalEntity){
        List<String> instrumentos = new ArrayList<>();        
        try {

            List<ProyectoInstrumentoEntity> instrumentosPorProyecto = proyectoInstrumentoRepository.findByProyectoMusical(proyectoMusicalEntity);
            
            for (ProyectoInstrumentoEntity instrumentosEntity : instrumentosPorProyecto) {
                String instrumento = instrumentosEntity.getInstrumento().getDescricpion();
                instrumentos.add(instrumento);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instrumentos;
    }

    public ProyectoMusical toObject(ProyectoMusicalEntity proyectoMusicalEntity){
        ProyectoMusical proyectoMusical = new ProyectoMusical();

        proyectoMusical.setNombre(proyectoMusicalEntity.getNombre());
        proyectoMusical.setTelefono(proyectoMusicalEntity.getTelefono());
        proyectoMusical.setDescripcion(proyectoMusicalEntity.getDescripcion());
        proyectoMusical.setGeneroMusical(obtenerGeneros(proyectoMusicalEntity));
        proyectoMusical.setInstrumentos(obtenerInstrumentos(proyectoMusicalEntity));
        proyectoMusical.setEmail(proyectoMusicalEntity.getEmail());

        return proyectoMusical;
    }

    public List<ProyectoMusical> toObjects(List<ProyectoMusicalEntity> proyectoMusicalesEntities){
        List<ProyectoMusical> proyectoMusicales = new ArrayList<>();
        
        for (ProyectoMusicalEntity proyectoMusicalEntity : proyectoMusicalesEntities) {
            ProyectoMusical proyectoMusical = toObject(proyectoMusicalEntity);
            proyectoMusicales.add(proyectoMusical);
        }

        return proyectoMusicales;
    }
}
