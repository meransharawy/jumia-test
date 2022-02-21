package com.jumia.test.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

    @Value("${spring.datasource.url}")
    String url;

    @Bean
    public DataSource sqliteDataSource() {
        SQLiteDataSource dataSource = new SQLiteDataSource ();
        dataSource.setUrl(url);
        return dataSource;
    }
}
