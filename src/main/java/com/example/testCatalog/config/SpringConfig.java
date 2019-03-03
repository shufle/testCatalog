package com.example.testCatalog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
    @ComponentScan(basePackages = {"com.example.testCatalog.dao", "com.example.testCatalog.services"})
    public class SpringConfig {



        @Bean
        public DataSource getDataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setUrl("jdbc:postgresql://localhost:5432/catalog");
            dataSource.setUsername("postgres");
            dataSource.setPassword("root");
            dataSource.setDriverClassName("org.postgresql.Driver");
            return dataSource;
        }





    }

