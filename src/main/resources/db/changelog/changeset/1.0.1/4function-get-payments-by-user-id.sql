--liquibase formatted sql
--changeset Priamonosov Maksim:1.0.1 splitStatements:false

drop function if exists get_payments_by_user_id;

create or replace function get_payments_by_user_id(user_idd bigint) returns payments as $$

begin
    return (select * from payments where user_id = user_idd);
end;

$$ language plpgsql;
