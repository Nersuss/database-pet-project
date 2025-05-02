--liquibase formatted sql
--changeset Priamonosov Maksim:1.0.1 splitStatements:false

create or replace function users_account_not_negative() returns trigger as $$

begin
    --
    if new.account < 0 then
        raise exception 'Sum of an account must be >= 0.';
    end if;

    return new;

end;

$$ language plpgsql;

create trigger users_account_not_negative before insert or update on users
    for each row execute function users_account_not_negative();
