--liquibase formatted sql
--changeset Priamonosov Maksim:1.0.0

create table payments(
    id bigint primary key,
    sum int8 not null,
    user_id bigint not null references users (id)
);
