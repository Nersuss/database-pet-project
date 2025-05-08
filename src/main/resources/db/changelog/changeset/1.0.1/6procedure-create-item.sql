--liquibase formatted sql
--changeset Priamonosov Maksim:1.0.1 splitStatements:false

create or replace procedure create_item(name varchar(255), cost bigint) as '

    insert into items (name, cost) values (name, cost);

' language sql;
