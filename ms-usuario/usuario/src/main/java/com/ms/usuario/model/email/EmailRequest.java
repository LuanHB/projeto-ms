package com.ms.usuario.model.email;

import lombok.Builder;

@Builder
public record EmailRequest(String usuarioId,
                           String emailTo,
                           String subject,
                           String mensagem) {
}
