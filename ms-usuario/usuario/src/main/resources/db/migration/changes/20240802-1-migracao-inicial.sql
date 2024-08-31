-- liquibase formatted sql
-- changeset luan.borghesan:migracao-inicial

create table usr_usuario
(
    usr_id    varchar(36)  not null,
    usr_nome  varchar(255) not null,
    usr_email varchar(255) not null,
    constraint pk_usuario primary key (usr_id)
);
