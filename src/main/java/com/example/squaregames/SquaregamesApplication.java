package com.example.squaregames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@SpringBootApplication
public class SquaregamesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SquaregamesApplication.class, args);
	}

    @Bean
    @Profile("h2")
    public DataSource h2DataSource() {
        return DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:mem:squaregame")
                .username("sa")
                .password("")
                .build();

    }

    @Bean
    @Profile("mysql")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("org.mariadb.jdbc.Driver")
                .url("jdbc:mariadb://localhost:3306/squaregame")
                .username("root")
                .password("fakepassword")
                .build();

    }

}
