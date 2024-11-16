package com.eufonia.eufonia_backend.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eufonia.eufonia_backend.api.proyecto.AgregarProyectoMusical;
import com.eufonia.eufonia_backend.api.proyecto.ProyectoMusical;
import com.eufonia.eufonia_backend.persistence.model.GeneroMusicalEntity;
import com.eufonia.eufonia_backend.persistence.model.InstrumentoEntity;
import com.eufonia.eufonia_backend.persistence.model.ProyectoGeneroEntity;
import com.eufonia.eufonia_backend.persistence.model.ProyectoInstrumentoEntity;
import com.eufonia.eufonia_backend.persistence.model.ProyectoMusicalEntity;
import com.eufonia.eufonia_backend.persistence.repository.GeneroMusicalRepository;
import com.eufonia.eufonia_backend.persistence.repository.InstrumentoRepository;
import com.eufonia.eufonia_backend.persistence.repository.ProyectoGeneroRepository;
import com.eufonia.eufonia_backend.persistence.repository.ProyectoInstrumentoRepository;

@Component
public class ProyectoMusicalFactory {

    @Autowired
    private ProyectoGeneroRepository proyectoGeneroRepository;

    @Autowired
    private ProyectoInstrumentoRepository proyectoInstrumentoRepository;

    @Autowired
    private GeneroMusicalRepository generoMusicalRepository;

    @Autowired
    private InstrumentoRepository instrumentoRepository;
    
    public List<String> obtenerGeneros(ProyectoMusicalEntity proyectoMusicalEntity){
        List<String> generos = new ArrayList<>();        
        try {

            List<ProyectoGeneroEntity> generosPorProyecto = proyectoGeneroRepository.findByProyectoMusicalEntity(proyectoMusicalEntity);
            
            for (ProyectoGeneroEntity proyectoGeneroEntity : generosPorProyecto) {
                String genero = proyectoGeneroEntity.getGenero().getNombre();
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

    public ProyectoMusicalEntity agregarEntity(AgregarProyectoMusical proyectoMusical){
        
        ProyectoMusicalEntity proyectoEntity = new ProyectoMusicalEntity();
        proyectoEntity.setNombre(proyectoMusical.getNombre());
        proyectoEntity.setTelefono(proyectoMusical.getTelefono());
        proyectoEntity.setDescripcion(proyectoMusical.getDescripcion());
        proyectoEntity.setEmail(proyectoMusical.getEmail());
        proyectoEntity.setPassword(proyectoMusical.getPassword()); 

        Boolean confirmacion = false;
        proyectoEntity.setConfirmado(confirmacion);

        return proyectoEntity;
    }

    public Boolean agregarGeneros(List<Integer> generos, ProyectoMusicalEntity proyectoMusicalEntity){
        Boolean exito = false;
        List<ProyectoGeneroEntity> generoEntities = new ArrayList<>();
        
        try {
            for (Integer idGenero : generos) {
                GeneroMusicalEntity generoMusicalEntity = generoMusicalRepository.getReferenceById(idGenero);
                ProyectoGeneroEntity proyectoGeneroEntity = new ProyectoGeneroEntity();

                proyectoGeneroEntity.setGenero(generoMusicalEntity);
                proyectoGeneroEntity.setProyectoMusicalEntity(proyectoMusicalEntity);

                generoEntities.add(proyectoGeneroEntity);
            }

            proyectoGeneroRepository.saveAll(generoEntities);        
            
            exito = true;
        } catch (Exception e) {
            e.printStackTrace();
            exito = false;
        }
        
        return exito;
    }

    public Boolean agregarInstrumentos(List<Integer> instrumentos, ProyectoMusicalEntity proyectoMusicalEntity){
        Boolean exito = false;
        List<ProyectoInstrumentoEntity> instrumentoEntities = new ArrayList<>();
        
        try {
            for (Integer idGenero : instrumentos) {
                InstrumentoEntity generoMusicalEntity = instrumentoRepository.getReferenceById(idGenero);
                ProyectoInstrumentoEntity proyectoInstrumentoEntity = new ProyectoInstrumentoEntity();

                proyectoInstrumentoEntity.setInstrumento(generoMusicalEntity);
                proyectoInstrumentoEntity.setProyectoMusical(proyectoMusicalEntity);

                instrumentoEntities.add(proyectoInstrumentoEntity);
            }

            proyectoInstrumentoRepository.saveAll(instrumentoEntities);        
            
            exito = true;
        } catch (Exception e) {
            e.printStackTrace();
            exito = false;
        }
        
        return exito;
    }
}
