package com.ms.email.model;

public record EmailRequest(String usuarioId,
                           String emailTo,
                           String subject,
                           String mensagem) {
}
