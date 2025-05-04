--liquibase formatted sql
--changeset Priamonosov Maksim:1.0.0

create table payments(
    id bigserial primary key,
    sum int8 not null,
    dest_email varchar(127) not null,
    user_id bigint not null references users (id)
);
