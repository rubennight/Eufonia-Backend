package com.eufonia.eufonia_backend.api.proyecto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eufonia.eufonia_backend.api.proyecto.correo_electronico.CorreoElectronicoService;
import com.eufonia.eufonia_backend.persistence.model.ConfirmacionTokenEntity;
import com.eufonia.eufonia_backend.persistence.model.ProyectoMusicalEntity;
import com.eufonia.eufonia_backend.persistence.repository.ConfirmacionTokenRepository;
import com.eufonia.eufonia_backend.persistence.repository.ProyectoMusicalRepository;
import com.eufonia.eufonia_backend.util.ProyectoMusicalFactory;

@Service
public class ProyectoService {
    
    @Autowired
    private ProyectoMusicalRepository proyectoMusicalRepository;

    @Autowired
    private ProyectoMusicalFactory proyectoMusicalFactory;

    @Autowired
    private ConfirmacionTokenRepository confirmacionTokenRepository;

    @Autowired
    private CorreoElectronicoService correoElectronicoService;

    public List<ProyectoMusical> obtenerTodosLosProyectos() {
        List<ProyectoMusicalEntity> proyectoMusicalEntities = proyectoMusicalRepository.findAll();
        List<ProyectoMusical> proyectosMusicales = proyectoMusicalFactory.toObjects(proyectoMusicalEntities);
        return proyectosMusicales;
    }

    @Transactional
    public boolean registrarProyecto(AgregarProyectoMusical proyectoMusical) {
        ProyectoMusicalEntity proyectoMusicalEntity = proyectoMusicalFactory.agregarEntity(proyectoMusical);
        Boolean exito = false;

        try {
            proyectoMusicalRepository.save(proyectoMusicalEntity);

            proyectoMusicalFactory.agregarGeneros(proyectoMusical.getGeneroMusical(), proyectoMusicalEntity);
            proyectoMusicalFactory.agregarInstrumentos(proyectoMusical.getInstrumentos(), proyectoMusicalEntity);

            // Generar un token de confirmación
            String token = UUID.randomUUID().toString();
            ConfirmacionTokenEntity confirmacionToken = new ConfirmacionTokenEntity();

            confirmacionToken.setIdConfirmacionToken(UUID.randomUUID());
            confirmacionToken.setToken(token);
            confirmacionToken.setExpiracion(LocalDateTime.now().plusHours(24)); // Token válido por 24 horas
            confirmacionToken.setProyectoMusical(proyectoMusicalEntity);

            // Guardar el token en la base de datos
            confirmacionTokenRepository.save(confirmacionToken);

            // Enviar el correo de confirmación
            String asunto = "Confirma tu registro en Eufonia Audio Studio";
            String texto = "Hola " + proyectoMusical.getNombre() + ",\n\n"
                    + "Gracias por registrarte en Eufonia Audio Studio. Por favor, confirma tu registro haciendo clic en el siguiente enlace:\n\n"
                    + "http://localhost:8080/eufonia/proyectoMusical/confirmarRegistro?token=" + token + "\n\n"
                    + "Este enlace es válido por 24 horas.\n\n"
                    + "Atentamente,\nEufonia Audio Studio.";

            correoElectronicoService.enviarCorreoDeConfirmacion(proyectoMusical.getEmail(), asunto, texto);  
            
            exito = true;
        } catch (Exception e) {
            e.printStackTrace();
            return exito;
        }

        return exito;
    }

    public ProyectoMusical confirmarRegistro(String token) {
        Boolean confirmado = true;
        ProyectoMusical proyectoMusical = new ProyectoMusical();
        
        // Buscar el token en la base de datos
        ConfirmacionTokenEntity confirmacionToken = confirmacionTokenRepository.findByToken(token)
        .orElseThrow(() -> new IllegalArgumentException("Token inválido o expirado"));

        // Validar si el token ha expirado
        if (confirmacionToken.getExpiracion().isBefore(LocalDateTime.now())) {
        throw new IllegalArgumentException("El token ha expirado");
        }

        if (confirmacionToken != null) {
            ProyectoMusicalEntity proyectoMusicalEntity = confirmacionToken.getProyectoMusical();
            proyectoMusicalEntity.setConfirmado(confirmado);
            proyectoMusicalRepository.save(proyectoMusicalEntity);

            proyectoMusical = proyectoMusicalFactory.toObject(proyectoMusicalEntity);
        }        

        // Opcionalmente eliminar el token después de usarlo
        confirmacionTokenRepository.delete(confirmacionToken);   

        return proyectoMusical;
    }
    
}
