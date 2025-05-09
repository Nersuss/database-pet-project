package ru.study.database_pg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.study.database_pg.init.InitDb;
import ru.study.database_pg.mq.Producer;

@SpringBootApplication
public class DatabasePgApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DatabasePgApplication.class, args);
    }

    @Autowired
    InitDb initDb;
    @Autowired
    Producer producer;
    @Override
    public void run(String... args) throws InterruptedException {
        initDb.createUsers();
        //initDb.makeTransfers();
        initDb.createItems();
        initDb.buyItems();

        for (int i = 0; i < 100; i++) {
            initDb.makeTransfers();
            Thread.sleep(300);
        }
    }
}
