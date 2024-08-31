package com.ms.usuario.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
//@Entity
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

//    @Id
    private String id;

    @PrePersist
    private void generatedId() {
        if (getId() == null) {
            setId(UUID.randomUUID().toString());
        }
    }
}
