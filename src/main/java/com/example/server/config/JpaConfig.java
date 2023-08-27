package com.example.server.config;

import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfig {

    @Bean
    public CamelCaseToUnderscoresNamingStrategy physicalNamingStrategy() {
        return new CamelCaseNamingStrategy();
    }
}
