package com.ms.usuario.controller;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.ms.usuario.entity.Usuario;
import com.ms.usuario.model.usuario.UsuarioRequest;
import com.ms.usuario.model.usuario.UsuarioResponse;
import com.ms.usuario.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // TODO adicionar o map struct

    @PostMapping
    public ResponseEntity<UsuarioResponse> createUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest) {

        var usuario = new Usuario();
        BeanUtils.copyProperties(usuarioRequest, usuario);
        usuario = service.salvar(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .build());
    }

}
