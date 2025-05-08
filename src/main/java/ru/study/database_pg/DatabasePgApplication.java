package ru.study.database_pg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.study.database_pg.init.InitDb;

@SpringBootApplication
public class DatabasePgApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DatabasePgApplication.class, args);
	}

	@Autowired
	InitDb initDb;

	@Override
	public void run(String... args) {
		initDb.createUsers();
		initDb.makeTransfers();
		initDb.createItems();
		initDb.buyItems();
	}
}
