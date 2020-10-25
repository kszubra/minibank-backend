package com.kszu.minibank.users.server.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@RefreshScope
public class PostgresConnectionConfiguration {

    @Value("${application.datasource.url}")
    private String url;

    @Value("${application.datasource.username}")
    private String username;

    @Value("${application.datasource.password}")
    private String password;

    @Value("${application.datasource.driver-class-name}")
    private String driver;

    @Bean
    @Primary
    @RefreshScope
    public DataSource datasource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }
}
