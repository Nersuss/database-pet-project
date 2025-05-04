--liquibase formatted sql
--changeset Priamonosov Maksim:1.0.1 splitStatements:false

create or replace procedure create_user(email varchar(255), password varchar(255), name varchar(255)) as '

    insert into users (email, password, name, account) values (email, password, name, 1000_00);

' language sql;
