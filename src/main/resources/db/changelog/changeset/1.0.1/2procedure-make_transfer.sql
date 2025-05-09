--liquibase formatted sql
--changeset Priamonosov Maksim:1.0.1 splitStatements:false

set transaction isolation level serializable;
create or replace procedure make_transfer(out_user_id bigint, dest_user_id bigint, sum int8) as $$

declare
    out_account int8 := (select account from users where id = out_user_id);
    dest_account int8 := (select account from users where id = dest_user_id);
begin
    if out_user_id = dest_user_id
        then raise exception 'You cannot send money myself.';
    end if;

    if out_account is null or dest_account is null
        then raise exception 'User not found: %', dest_user_id;
    end if;

    update users set account=account-sum where id = out_user_id;
    update users set account=account+sum where id = dest_user_id;

    insert into transfers(sum, dest_user_id, user_id) values (sum, dest_user_id, out_user_id);
end;
$$ language plpgsql;
