package com.kszu.minibank.accounts.server.configuration;

import com.kszu.minibank.accounts.server.service.SimpleAccountNumberGenerator;
import com.kszu.minibank.accounts.server.service.interfaces.AccountNumberGenerator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.kszu.minibank.accounts.server.domain.repository")
@EntityScan(basePackages = {"com.kszu.minibank.accounts.server.domain.model"})
@ComponentScan(basePackages = {"com.kszu.minibank.accounts.server.service.*"})
public class CoreConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public AccountNumberGenerator accountNumberGenerator() {
        return new SimpleAccountNumberGenerator();
    }
}
