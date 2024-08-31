package com.ms.email.service;

import com.ms.email.entity.Email;
import com.ms.email.enumerate.EnumStatusEmail;
import com.ms.email.repository.EmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    private final EmailRepository repository;
    private final JavaMailSender javaMailSender;

    public EmailService(EmailRepository repository,
                        JavaMailSender javaMailSender) {
        this.repository = repository;
        this.javaMailSender = javaMailSender;
    }

    @Transactional
    public void sendEmail(Email email) {

        try {
            email.setDataEnvioemail(LocalDateTime.now());
            email.setEmailFrom(emailFrom);
            email.setStatusEmail(EnumStatusEmail.ENVIADO);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getMensagem());

            javaMailSender.send(message);

        } catch (MailException e) {
            email.setStatusEmail(EnumStatusEmail.ERRO);

        } finally {
            repository.save(email);
        }
    }
}
