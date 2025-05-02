--liquibase formatted sql
--changeset Priamonosov Maksim:1.0.1

create or replace procedure make_pay(out_email varchar(255), dest_email varchar(255), sum int8) as '

    insert into users (email, password, name, account) values (email, password, name, 100000);

' language sql;

