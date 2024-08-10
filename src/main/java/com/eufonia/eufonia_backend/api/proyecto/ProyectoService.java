package com.eufonia.eufonia_backend.api.proyecto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eufonia.eufonia_backend.api.proyecto.correo_electronico.CorreoElectronicoService;
import com.eufonia.eufonia_backend.persistence.model.ConfirmacionTokenEntity;
import com.eufonia.eufonia_backend.persistence.model.ProyectoEntity;
import com.eufonia.eufonia_backend.persistence.repository.ConfirmacionTokenRepository;
import com.eufonia.eufonia_backend.persistence.repository.ProyectoRepository;

@Service
public class ProyectoService {
    
    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private ConfirmacionTokenRepository confirmacionTokenRepository;

    @Autowired
    private CorreoElectronicoService correoElectronicoService;

    public List<ProyectoMusical> obtenerTodosLosProyectos(){
        List<ProyectoMusical> proyectosMusicales = new ArrayList<>();

        try {
            List<ProyectoEntity> proyectoEntities = proyectoRepository.findAll();

            proyectosMusicales = ProyectoFactory.toListObject(proyectoEntities);

        } catch (Exception e) {
            e.getStackTrace();
        }

        return proyectosMusicales;
    }

    public Boolean registrarProyecto(ProyectoMusical proyectoMusical){
        try{
            ProyectoEntity proyectoEntity = ProyectoFactory.toEntity(proyectoMusical);

            proyectoRepository.save(proyectoEntity);

            String token = UUID.randomUUID().toString();
            ConfirmacionTokenEntity confirmacionTokenEntity = new ConfirmacionTokenEntity();

            confirmacionTokenEntity.setIdToken(UUID.randomUUID());
            confirmacionTokenEntity.setProyecto(proyectoEntity);
            confirmacionTokenEntity.setToken(token);
            confirmacionTokenEntity.setExpiracion(LocalDateTime.now().plusHours(24));

            confirmacionTokenRepository.save(confirmacionTokenEntity);

            String linkDeConfirmacion = "http://localhost:8080/confirmarRegistro?token=" + token;
            String textoDeCorreoElectronico = "¡Hola! estamos emocionados por trabajar con tu proyecto musical " + proyectoMusical.getNombre() + "." + "\n\n" +
                                                "Por favor confirma tu registro haciendo clic en el siguiente enlace: \n" + 
                                                linkDeConfirmacion;
            
            correoElectronicoService.enviarCorreoDeConfirmacion(proyectoMusical.getEmail(), "Confirma tu correo electrónico - Eufonía", textoDeCorreoElectronico);
            
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public ProyectoMusical confirmarRegistro(String token){
        Optional<ConfirmacionTokenEntity> confirmacionTokenEntity = confirmacionTokenRepository.findByToken(token);
        ProyectoMusical proyectoMusical = new ProyectoMusical();

        if (confirmacionTokenEntity.isPresent()) {
            ConfirmacionTokenEntity confirmacionToken = confirmacionTokenEntity.get();

            if(confirmacionToken.getExpiracion().isAfter(LocalDateTime.now())){
                ProyectoEntity proyectoEntity = confirmacionToken.getProyecto();

                if(proyectoEntity != null){
                    proyectoEntity.setConfirmado(true);
                    proyectoRepository.save(proyectoEntity);

                    proyectoMusical = ProyectoFactory.toObject(proyectoEntity);
                    return proyectoMusical;
                }
            } else {
                throw new RuntimeException("El token ha expirado.");
            }
        }
        return proyectoMusical;
    }

}
