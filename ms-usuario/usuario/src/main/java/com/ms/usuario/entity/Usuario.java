package com.ms.usuario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usr_usuario")
public class Usuario {

    @Id
    @Column(name = "usr_id")
    private String id;

    @Column(name = "usr_nome", nullable = false)
    private String nome;

    @Column(name = "usr_email", nullable = false)
    private String email;

    @PrePersist
    private void generatedId() {
        if (getId() == null) {
            setId(UUID.randomUUID().toString());
        }
    }

}

