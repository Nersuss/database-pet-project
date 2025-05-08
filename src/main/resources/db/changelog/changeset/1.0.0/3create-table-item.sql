--liquibase formatted sql
--changeset Priamonosov Maksim:1.0.0

create table items(
    id bigserial primary key,
    name varchar(255) not null,
    cost int8 not null,
    user_id bigint,

    foreign key (user_id) references users (id) on delete cascade
);
