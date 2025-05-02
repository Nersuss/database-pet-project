package ru.study.database_pg.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;


@Component
public class InsertUsers {

//
//    @Bean
//    public DataSource getDataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("org.postgresql.Driver");
//        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/pay-system");
//        dataSourceBuilder.username("postgres");
//        dataSourceBuilder.password("postgres");
//        return dataSourceBuilder.build();
//    }



}
