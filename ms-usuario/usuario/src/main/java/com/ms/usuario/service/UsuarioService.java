package com.ms.usuario.service;

import com.ms.usuario.entity.Usuario;
import com.ms.usuario.producer.UsuarioProducer;
import com.ms.usuario.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioProducer usuarioProducer;

    public UsuarioService(UsuarioRepository repository,
                          UsuarioProducer usuarioProducer) {
        this.repository = repository;
        this.usuarioProducer = usuarioProducer;
    }

    @Transactional(rollbackOn = Exception.class)
    public Usuario salvar(Usuario usuario) {

        usuario = repository.save(usuario);
        usuarioProducer.publicarMensagemEmail(usuario);

        return usuario;
    }
}
