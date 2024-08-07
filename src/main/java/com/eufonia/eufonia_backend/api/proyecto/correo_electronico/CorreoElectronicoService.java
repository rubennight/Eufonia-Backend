package com.eufonia.eufonia_backend.api.proyecto.correo_electronico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CorreoElectronicoService {
    
    @Autowired
    private JavaMailSender mailSender;

    public void enviarCorreoDeConfirmacion(String receptor, String asunto, String texto){
        SimpleMailMessage mensaje = new SimpleMailMessage();

        mensaje.setTo(receptor);
        mensaje.setSubject(asunto);
        mensaje.setText(texto);

        mailSender.send(mensaje);
    }
    
}
