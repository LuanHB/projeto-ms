package com.ms.usuario.model.usuario;

import lombok.Builder;

@Builder
public record UsuarioResponse(String id,
                              String nome,
                              String email) {
}
