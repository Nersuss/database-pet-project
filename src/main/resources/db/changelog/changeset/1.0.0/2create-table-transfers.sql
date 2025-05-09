--liquibase formatted sql
--changeset Priamonosov Maksim:1.0.0

create table transfers(
    id bigserial primary key,
    sum int8 not null,
    dest_user_id bigint not null,
    user_id bigint not null,
    foreign key (user_id) references users (id) on delete cascade
);
