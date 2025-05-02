--liquibase formatted sql
--changeset Priamonosov Maksim:1.0.1 splitStatements:false

create or replace procedure make_pay(out_email varchar(255), dest_email varchar(255), sum int8) as $$

declare
    out_account int8 := (select account from users where email = out_email);
    dest_account int8 := (select account from users where email = dest_email);
begin
    if out_email = dest_email
        then raise exception 'You cannot send money myself.';
    end if;

    if out_account is null or dest_account is null
        then raise exception 'User not found: %', dest_email;
    end if;

    update users set account=account-sum where email = out_email;
    update users set account=account+sum where email = dest_email;
end;
$$ language plpgsql;

