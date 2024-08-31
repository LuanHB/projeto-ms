package com.ms.email.entity;

import com.ms.email.enumerate.EnumStatusEmail;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "eml_email")
public class Email {

    @Id
    private String id;

    @Column(nullable = false)
    private String usuarioId;

    @Column(nullable = false)
    private String emailFrom;

    @Column(nullable = false)
    private String emailTo;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String mensagem;

    @Column(nullable = false)
    private LocalDateTime dataEnvioemail;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnumStatusEmail StatusEmail;

    @Column(nullable = false)

    @PrePersist
    private void generatedId() {
        if (getId() == null) {
            setId(UUID.randomUUID().toString());
        }
    }
}
