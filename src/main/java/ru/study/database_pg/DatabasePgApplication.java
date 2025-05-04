package ru.study.database_pg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.study.database_pg.init.InsertUsers;

@SpringBootApplication
public class DatabasePgApplication implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DatabasePgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String sql_create_user = "call create_user(?, ?, ?)";
		jdbcTemplate.update(sql_create_user, "email1", "secret", "Maks");
		jdbcTemplate.update(sql_create_user, "email2", "secret", "Rus");
		jdbcTemplate.update(sql_create_user, "email3", "secret", "Efim");
		jdbcTemplate.update(sql_create_user, "email4", "secret", "Zhenya");

		String sql_make_pay = "call make_pay(?, ?, ?)";
		int res = jdbcTemplate.update(sql_make_pay, "email1", "email2", 1000);

//		String sql_get_payments = "get_payments_by_user_id(?)";
//		System.out.println(jdbcTemplate.update(sql_get_payments, 1));

	}
}
