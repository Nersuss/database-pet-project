--liquibase formatted sql
--changeset Priamonosov Maksim:1.0.1 splitStatements:false

set transaction isolation level serializable;
create or replace procedure buy_item_by_ids(u_user_id bigint, item_id bigint) as $$

declare
    item_user_id bigint := (select user_id from items where id = item_id);
    item_name varchar(255) = (select name from items where id = item_id);
    item_cost bigint := (select cost from items where id = item_id);
    user_account bigint := (select account from users where id = u_user_id);
begin
    if item_user_id is not distinct from u_user_id
        then raise exception 'You already have this item: %', item_name;
    end if;

    if item_user_id is not null
        then raise exception 'This item bought: %', item_name;
    end if;

    if user_account < item_cost
        then raise exception 'Not enought money to buy: %', item_name;
    end if;

    update users set account=account-item_cost where id = u_user_id;
    update items set user_id = u_user_id where id = item_id;

end;
$$ language plpgsql;
