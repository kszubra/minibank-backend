package com.kszu.minibank.transactions.server.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.kszu.minibank.transactions.server.domain.repository")
@EntityScan(basePackages = {"com.kszu.minibank.transactions.server.domain.model"})
@ComponentScan(basePackages = {"com.kszu.minibank.transactions.server.service.*"})
public class CoreConfiguration {

}
