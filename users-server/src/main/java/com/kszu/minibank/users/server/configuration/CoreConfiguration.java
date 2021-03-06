package com.kszu.minibank.users.server.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.kszu.minibank.users.server.domain.repository")
@EntityScan(basePackages = {"com.kszu.minibank.users.server.domain.model"})
@ComponentScan(basePackages = {"com.kszu.minibank.users.server.service.*"})
public class CoreConfiguration {

}
