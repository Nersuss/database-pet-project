package ru.study.database_pg.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.study.database_pg.mq.Producer;

@Component
public class InitDb {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    Producer producer;
    public void createUsers() {
        String sql = "call create_user(?, ?, ?)";
        jdbcTemplate.update(sql, "email1", "secret", "Maks");
        jdbcTemplate.update(sql, "email2", "secret", "Rus");
        jdbcTemplate.update(sql, "email3", "secret", "Efim");
        jdbcTemplate.update(sql, "email4", "secret", "Zhenya");
    }

    public void makeTransfers(){
        String sql = "call make_transfer(?, ?, ?)";
        jdbcTemplate.update(sql, 1, 2, 100);
        producer.send("base", "made some transfer");
        jdbcTemplate.update(sql, 2, 3, 100);
        producer.send("base", "made some transfer");
        jdbcTemplate.update(sql, 3, 4, 100);
        producer.send("base", "made some transfer");
    }

    public void createItems() {
        String sql = "call create_item(?, ?)";
        jdbcTemplate.update(sql, "Xiaomi redmi note 9", 6666);
    }

    public void buyItems(){
        String sql = "call buy_item_by_ids(?, ?)";
        jdbcTemplate.update(sql, 1, 1);
    }

}
