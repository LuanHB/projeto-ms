package com.ms.usuario.producer;

import com.ms.usuario.entity.Usuario;
import com.ms.usuario.model.email.EmailRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UsuarioProducer {

    @Value("${broker.queue.email.name}")
    private String routingKey;

    final RabbitTemplate rabbitTemplate;

    public UsuarioProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publicarMensagemEmail(Usuario usuario) {
        var emailRequest = EmailRequest.builder()
                .usuarioId(usuario.getId())
                .emailTo(usuario.getEmail())
                .subject("Cadastro realizado com sucesso!")
                .mensagem("Olá ".concat(usuario.getNome()).concat(", seja bem vindo(a)!"))
                .build();


        rabbitTemplate.convertAndSend("", routingKey, emailRequest);
    }

}
