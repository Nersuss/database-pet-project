--liquibase formatted sql
--changeset Priamonosov Maksim:1.0.0

create table purchases(
    id bigserial primary key,
    date timestamp not null,
    user_id bigint not null,
    item_id bigint not null,

    foreign key (user_id) references users (id) on delete cascade,
    foreign key (item_id) references items (id) on delete cascade
);
