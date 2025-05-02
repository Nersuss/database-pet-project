--liquibase formatted sql
--changeset Priamonosov Maksim:1.0.0

create table users(
    id bigserial primary key,
    email varchar(127) not null unique,
    password varchar(127) not null,
    name varchar(127) not null,
    account int8 not null default 000
);
